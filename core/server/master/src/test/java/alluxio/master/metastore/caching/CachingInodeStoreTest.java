/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.metastore.caching;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import alluxio.conf.ConfigurationBuilder;
import alluxio.conf.PropertyKey;
import alluxio.master.file.contexts.CreateDirectoryContext;
import alluxio.master.file.contexts.CreateFileContext;
import alluxio.master.file.meta.Inode;
import alluxio.master.file.meta.InodeLockManager;
import alluxio.master.file.meta.MutableInodeDirectory;
import alluxio.master.file.meta.MutableInodeFile;
import alluxio.master.metastore.InodeStore;
import alluxio.master.metastore.InodeStore.InodeStoreArgs;
import alluxio.master.metastore.heap.HeapInodeStore;

import com.google.common.collect.Iterables;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CachingInodeStoreTest {
  private static final long CACHE_SIZE = 20;
  private static final long TEST_INODE_ID = 5;
  private static final MutableInodeDirectory TEST_INODE_DIR =
      MutableInodeDirectory.create(TEST_INODE_ID, 0, "name", CreateDirectoryContext.defaults());

  private InodeStore mBackingStore;
  private CachingInodeStore mStore;

  @Before
  public void before() {
    InodeStoreArgs args = new InodeStoreArgs(new InodeLockManager(),
        new ConfigurationBuilder()
            .setProperty(PropertyKey.MASTER_METASTORE_INODE_CACHE_MAX_SIZE, CACHE_SIZE)
            .build());
    mBackingStore = spy(new HeapInodeStore(args));
    mStore = new CachingInodeStore(mBackingStore, args);
    mStore.writeNewInode(TEST_INODE_DIR);
  }

  @After
  public void after() {
    mStore.close();
  }

  @Test
  public void cacheGetMutable() {
    for (int i = 0; i < 10; i++) {
      assertEquals(TEST_INODE_DIR, mStore.getMutable(TEST_INODE_ID).get());
    }

    verifyNoBackingStoreReads();
  }

  @Test
  public void cacheGet() {
    Inode testInode = Inode.wrap(TEST_INODE_DIR);
    for (int i = 0; i < 10; i++) {
      assertEquals(testInode, mStore.get(TEST_INODE_ID).get());
    }

    verifyNoBackingStoreReads();
  }

  @Test
  public void removeInodeStaysRemoved() {
    mStore.remove(TEST_INODE_DIR);

    assertEquals(Optional.empty(), mStore.get(TEST_INODE_DIR.getId()));
  }

  @Test
  public void reflectWrite() {
    MutableInodeDirectory updated = MutableInodeDirectory.create(TEST_INODE_ID, 10, "newName",
        CreateDirectoryContext.defaults());
    mStore.writeInode(updated);

    assertEquals("newName", mStore.get(TEST_INODE_ID).get().getName());
  }

  @Test
  public void cacheGetChild() {
    MutableInodeFile child =
        MutableInodeFile.create(0, TEST_INODE_ID, "child", 0, CreateFileContext.defaults());
    mStore.writeInode(child);
    mStore.addChild(TEST_INODE_ID, child);
    for (int i = 0; i < 10; i++) {
      assertTrue(mStore.getChild(TEST_INODE_DIR, "child").isPresent());
    }

    verifyNoBackingStoreReads();
  }

  @Test
  public void cacheGetChildrenInodeLookups() {
    List<Inode> children = new ArrayList<>();
    for (int id = 100; id < 110; id++) {
      MutableInodeFile child =
          MutableInodeFile.create(id, TEST_INODE_ID, "child" + id, 0, CreateFileContext.defaults());
      children.add(Inode.wrap(child));
      mStore.writeNewInode(child);
      mStore.addChild(TEST_INODE_ID, child);
    }
    assertEquals(10, Iterables.size(mStore.getChildren(TEST_INODE_DIR)));

    verifyNoBackingStoreReads();
  }

  @Test
  public void eviction() {
    for (int id = 100; id < 100 + CACHE_SIZE * 2; id++) {
      MutableInodeFile child =
          MutableInodeFile.create(id, TEST_INODE_ID, "child" + id, 0, CreateFileContext.defaults());
      mStore.writeInode(child);
      mStore.addChild(TEST_INODE_ID, child);
    }
    for (int id = 100; id < 100 + CACHE_SIZE * 2; id++) {
      assertTrue(mStore.getChild(TEST_INODE_DIR, "child" + id).isPresent());
    }
    verify(mBackingStore, Mockito.atLeastOnce()).getMutable(anyLong());
  }

  @Test
  public void edgeIndexTest() throws Exception {
    // Run many concurrent operations, then check that the edge cache's indices are accurate.
    long endTimeMs = System.currentTimeMillis() + 200;
    ThreadLocalRandom random = ThreadLocalRandom.current();
    List<MutableInodeDirectory> dirs = new ArrayList<>();
    for (int i = 1; i < 5; i++) {
      MutableInodeDirectory dir = inodeDir(i, 0);
      dirs.add(dir);
      mStore.writeInode(dir);
      mStore.addChild(TEST_INODE_ID, dir);
    }

    AtomicInteger operations = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(10);
    int numThreads = 10;
    executor.invokeAll(Collections.nCopies(numThreads, () -> {
      while (operations.get() < 10_000 || System.currentTimeMillis() < endTimeMs) {
        // Sometimes add, sometimes delete.
        if (random.nextBoolean()) {
          MutableInodeDirectory dir = inodeDir(random.nextLong(10, 15), random.nextLong(1, 5));
          mStore.writeInode(dir);
          mStore.addChild(dir.getParentId(), dir);
        } else {
          mStore.removeChild(dirs.get(random.nextInt(dirs.size())).getId(),
              Long.toString(random.nextLong(10, 15)));
        }
        operations.incrementAndGet();
        assertTrue(mStore.mEdgeCache.mMap.size() <= CACHE_SIZE + numThreads);
      }
      return null;
    }));
    alluxio.util.CommonUtils.waitFor("eviction thread to finish",
        () -> mStore.mEdgeCache.mEvictionThread.mIsSleeping);
    mStore.mEdgeCache.verifyIndices();
  }

  @Test
  public void listingCacheManyDirsEviction() throws Exception {
    for (int i = 1; i < CACHE_SIZE * 3; i++) {
      mStore.writeNewInode(inodeDir(i, TEST_INODE_ID));
    }
    assertFalse(mStore.mListingCache.getCachedChildIds(TEST_INODE_ID).isPresent());
  }

  @Test
  public void listingCacheBigDirEviction() throws Exception {
    MutableInodeDirectory bigDir = inodeDir(1, 0);
    mStore.writeNewInode(bigDir);
    long dirSize = CACHE_SIZE;
    for (int i = 2; i < 2 + CACHE_SIZE; i++) {
      mStore.addChild(bigDir.getId(), inodeDir(i, bigDir.getId()));
    }
    // Cache the large directory
    assertEquals(dirSize, Iterables.size(mStore.getChildIds(bigDir.getId())));
    // Perform another operation to trigger eviction
    mStore.addChild(bigDir.getId(), inodeDir(10000, bigDir.getId()));
    assertFalse(mStore.mListingCache.getCachedChildIds(TEST_INODE_ID).isPresent());
  }

  private static MutableInodeDirectory inodeDir(long id, long parentId) {
    return MutableInodeDirectory.create(id, parentId, Long.toString(id),
        CreateDirectoryContext.defaults());
  }

  private void verifyNoBackingStoreReads() {
    verify(mBackingStore, Mockito.times(0)).getChild(anyLong(), anyString());
    verify(mBackingStore, Mockito.times(0)).getChildId(anyLong(), anyString());
    verify(mBackingStore, Mockito.times(0)).getChildren(anyLong());
    verify(mBackingStore, Mockito.times(0)).getChildIds(anyLong());
    verify(mBackingStore, Mockito.times(0)).get(anyLong());
    verify(mBackingStore, Mockito.times(0)).getMutable(anyLong());
  }
}
