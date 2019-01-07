// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: block_worker.proto

package alluxio.grpc;

/**
 * <pre>
 * The read request.
 * next available id: 6
 * </pre>
 *
 * Protobuf type {@code alluxio.grpc.ReadRequest}
 */
public  final class ReadRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:alluxio.grpc.ReadRequest)
    ReadRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReadRequest.newBuilder() to construct.
  private ReadRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReadRequest() {
    blockId_ = 0L;
    offset_ = 0L;
    length_ = 0L;
    promote_ = false;
    chunkSize_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReadRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            bitField0_ |= 0x00000001;
            blockId_ = input.readInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            offset_ = input.readInt64();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            length_ = input.readInt64();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            promote_ = input.readBool();
            break;
          }
          case 40: {
            bitField0_ |= 0x00000010;
            chunkSize_ = input.readInt64();
            break;
          }
          case 50: {
            alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder subBuilder = null;
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
              subBuilder = openUfsBlockOptions_.toBuilder();
            }
            openUfsBlockOptions_ = input.readMessage(alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(openUfsBlockOptions_);
              openUfsBlockOptions_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000020;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return alluxio.grpc.BlockWorkerProto.internal_static_alluxio_grpc_ReadRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return alluxio.grpc.BlockWorkerProto.internal_static_alluxio_grpc_ReadRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            alluxio.grpc.ReadRequest.class, alluxio.grpc.ReadRequest.Builder.class);
  }

  private int bitField0_;
  public static final int BLOCK_ID_FIELD_NUMBER = 1;
  private long blockId_;
  /**
   * <code>optional int64 block_id = 1;</code>
   */
  public boolean hasBlockId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int64 block_id = 1;</code>
   */
  public long getBlockId() {
    return blockId_;
  }

  public static final int OFFSET_FIELD_NUMBER = 2;
  private long offset_;
  /**
   * <code>optional int64 offset = 2;</code>
   */
  public boolean hasOffset() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional int64 offset = 2;</code>
   */
  public long getOffset() {
    return offset_;
  }

  public static final int LENGTH_FIELD_NUMBER = 3;
  private long length_;
  /**
   * <code>optional int64 length = 3;</code>
   */
  public boolean hasLength() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional int64 length = 3;</code>
   */
  public long getLength() {
    return length_;
  }

  public static final int PROMOTE_FIELD_NUMBER = 4;
  private boolean promote_;
  /**
   * <pre>
   * Whether the block should be promoted before reading
   * </pre>
   *
   * <code>optional bool promote = 4;</code>
   */
  public boolean hasPromote() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <pre>
   * Whether the block should be promoted before reading
   * </pre>
   *
   * <code>optional bool promote = 4;</code>
   */
  public boolean getPromote() {
    return promote_;
  }

  public static final int CHUNK_SIZE_FIELD_NUMBER = 5;
  private long chunkSize_;
  /**
   * <code>optional int64 chunk_size = 5;</code>
   */
  public boolean hasChunkSize() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional int64 chunk_size = 5;</code>
   */
  public long getChunkSize() {
    return chunkSize_;
  }

  public static final int OPEN_UFS_BLOCK_OPTIONS_FIELD_NUMBER = 6;
  private alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions openUfsBlockOptions_;
  /**
   * <pre>
   * This is only set for UFS block read.
   * </pre>
   *
   * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
   */
  public boolean hasOpenUfsBlockOptions() {
    return ((bitField0_ & 0x00000020) == 0x00000020);
  }
  /**
   * <pre>
   * This is only set for UFS block read.
   * </pre>
   *
   * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
   */
  public alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions getOpenUfsBlockOptions() {
    return openUfsBlockOptions_ == null ? alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.getDefaultInstance() : openUfsBlockOptions_;
  }
  /**
   * <pre>
   * This is only set for UFS block read.
   * </pre>
   *
   * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
   */
  public alluxio.proto.dataserver.Protocol.OpenUfsBlockOptionsOrBuilder getOpenUfsBlockOptionsOrBuilder() {
    return openUfsBlockOptions_ == null ? alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.getDefaultInstance() : openUfsBlockOptions_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeInt64(1, blockId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeInt64(2, offset_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeInt64(3, length_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeBool(4, promote_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeInt64(5, chunkSize_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      output.writeMessage(6, getOpenUfsBlockOptions());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, blockId_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, offset_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, length_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, promote_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, chunkSize_);
    }
    if (((bitField0_ & 0x00000020) == 0x00000020)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getOpenUfsBlockOptions());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof alluxio.grpc.ReadRequest)) {
      return super.equals(obj);
    }
    alluxio.grpc.ReadRequest other = (alluxio.grpc.ReadRequest) obj;

    boolean result = true;
    result = result && (hasBlockId() == other.hasBlockId());
    if (hasBlockId()) {
      result = result && (getBlockId()
          == other.getBlockId());
    }
    result = result && (hasOffset() == other.hasOffset());
    if (hasOffset()) {
      result = result && (getOffset()
          == other.getOffset());
    }
    result = result && (hasLength() == other.hasLength());
    if (hasLength()) {
      result = result && (getLength()
          == other.getLength());
    }
    result = result && (hasPromote() == other.hasPromote());
    if (hasPromote()) {
      result = result && (getPromote()
          == other.getPromote());
    }
    result = result && (hasChunkSize() == other.hasChunkSize());
    if (hasChunkSize()) {
      result = result && (getChunkSize()
          == other.getChunkSize());
    }
    result = result && (hasOpenUfsBlockOptions() == other.hasOpenUfsBlockOptions());
    if (hasOpenUfsBlockOptions()) {
      result = result && getOpenUfsBlockOptions()
          .equals(other.getOpenUfsBlockOptions());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasBlockId()) {
      hash = (37 * hash) + BLOCK_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getBlockId());
    }
    if (hasOffset()) {
      hash = (37 * hash) + OFFSET_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getOffset());
    }
    if (hasLength()) {
      hash = (37 * hash) + LENGTH_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getLength());
    }
    if (hasPromote()) {
      hash = (37 * hash) + PROMOTE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getPromote());
    }
    if (hasChunkSize()) {
      hash = (37 * hash) + CHUNK_SIZE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getChunkSize());
    }
    if (hasOpenUfsBlockOptions()) {
      hash = (37 * hash) + OPEN_UFS_BLOCK_OPTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getOpenUfsBlockOptions().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static alluxio.grpc.ReadRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.ReadRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.ReadRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.ReadRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static alluxio.grpc.ReadRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.ReadRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(alluxio.grpc.ReadRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The read request.
   * next available id: 6
   * </pre>
   *
   * Protobuf type {@code alluxio.grpc.ReadRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:alluxio.grpc.ReadRequest)
      alluxio.grpc.ReadRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return alluxio.grpc.BlockWorkerProto.internal_static_alluxio_grpc_ReadRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return alluxio.grpc.BlockWorkerProto.internal_static_alluxio_grpc_ReadRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              alluxio.grpc.ReadRequest.class, alluxio.grpc.ReadRequest.Builder.class);
    }

    // Construct using alluxio.grpc.ReadRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getOpenUfsBlockOptionsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      blockId_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      offset_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000002);
      length_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000004);
      promote_ = false;
      bitField0_ = (bitField0_ & ~0x00000008);
      chunkSize_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000010);
      if (openUfsBlockOptionsBuilder_ == null) {
        openUfsBlockOptions_ = null;
      } else {
        openUfsBlockOptionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return alluxio.grpc.BlockWorkerProto.internal_static_alluxio_grpc_ReadRequest_descriptor;
    }

    public alluxio.grpc.ReadRequest getDefaultInstanceForType() {
      return alluxio.grpc.ReadRequest.getDefaultInstance();
    }

    public alluxio.grpc.ReadRequest build() {
      alluxio.grpc.ReadRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public alluxio.grpc.ReadRequest buildPartial() {
      alluxio.grpc.ReadRequest result = new alluxio.grpc.ReadRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.blockId_ = blockId_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.offset_ = offset_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.length_ = length_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.promote_ = promote_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      result.chunkSize_ = chunkSize_;
      if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
        to_bitField0_ |= 0x00000020;
      }
      if (openUfsBlockOptionsBuilder_ == null) {
        result.openUfsBlockOptions_ = openUfsBlockOptions_;
      } else {
        result.openUfsBlockOptions_ = openUfsBlockOptionsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof alluxio.grpc.ReadRequest) {
        return mergeFrom((alluxio.grpc.ReadRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(alluxio.grpc.ReadRequest other) {
      if (other == alluxio.grpc.ReadRequest.getDefaultInstance()) return this;
      if (other.hasBlockId()) {
        setBlockId(other.getBlockId());
      }
      if (other.hasOffset()) {
        setOffset(other.getOffset());
      }
      if (other.hasLength()) {
        setLength(other.getLength());
      }
      if (other.hasPromote()) {
        setPromote(other.getPromote());
      }
      if (other.hasChunkSize()) {
        setChunkSize(other.getChunkSize());
      }
      if (other.hasOpenUfsBlockOptions()) {
        mergeOpenUfsBlockOptions(other.getOpenUfsBlockOptions());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      alluxio.grpc.ReadRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (alluxio.grpc.ReadRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long blockId_ ;
    /**
     * <code>optional int64 block_id = 1;</code>
     */
    public boolean hasBlockId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int64 block_id = 1;</code>
     */
    public long getBlockId() {
      return blockId_;
    }
    /**
     * <code>optional int64 block_id = 1;</code>
     */
    public Builder setBlockId(long value) {
      bitField0_ |= 0x00000001;
      blockId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 block_id = 1;</code>
     */
    public Builder clearBlockId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      blockId_ = 0L;
      onChanged();
      return this;
    }

    private long offset_ ;
    /**
     * <code>optional int64 offset = 2;</code>
     */
    public boolean hasOffset() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int64 offset = 2;</code>
     */
    public long getOffset() {
      return offset_;
    }
    /**
     * <code>optional int64 offset = 2;</code>
     */
    public Builder setOffset(long value) {
      bitField0_ |= 0x00000002;
      offset_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 offset = 2;</code>
     */
    public Builder clearOffset() {
      bitField0_ = (bitField0_ & ~0x00000002);
      offset_ = 0L;
      onChanged();
      return this;
    }

    private long length_ ;
    /**
     * <code>optional int64 length = 3;</code>
     */
    public boolean hasLength() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int64 length = 3;</code>
     */
    public long getLength() {
      return length_;
    }
    /**
     * <code>optional int64 length = 3;</code>
     */
    public Builder setLength(long value) {
      bitField0_ |= 0x00000004;
      length_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 length = 3;</code>
     */
    public Builder clearLength() {
      bitField0_ = (bitField0_ & ~0x00000004);
      length_ = 0L;
      onChanged();
      return this;
    }

    private boolean promote_ ;
    /**
     * <pre>
     * Whether the block should be promoted before reading
     * </pre>
     *
     * <code>optional bool promote = 4;</code>
     */
    public boolean hasPromote() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <pre>
     * Whether the block should be promoted before reading
     * </pre>
     *
     * <code>optional bool promote = 4;</code>
     */
    public boolean getPromote() {
      return promote_;
    }
    /**
     * <pre>
     * Whether the block should be promoted before reading
     * </pre>
     *
     * <code>optional bool promote = 4;</code>
     */
    public Builder setPromote(boolean value) {
      bitField0_ |= 0x00000008;
      promote_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Whether the block should be promoted before reading
     * </pre>
     *
     * <code>optional bool promote = 4;</code>
     */
    public Builder clearPromote() {
      bitField0_ = (bitField0_ & ~0x00000008);
      promote_ = false;
      onChanged();
      return this;
    }

    private long chunkSize_ ;
    /**
     * <code>optional int64 chunk_size = 5;</code>
     */
    public boolean hasChunkSize() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int64 chunk_size = 5;</code>
     */
    public long getChunkSize() {
      return chunkSize_;
    }
    /**
     * <code>optional int64 chunk_size = 5;</code>
     */
    public Builder setChunkSize(long value) {
      bitField0_ |= 0x00000010;
      chunkSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 chunk_size = 5;</code>
     */
    public Builder clearChunkSize() {
      bitField0_ = (bitField0_ & ~0x00000010);
      chunkSize_ = 0L;
      onChanged();
      return this;
    }

    private alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions openUfsBlockOptions_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptionsOrBuilder> openUfsBlockOptionsBuilder_;
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public boolean hasOpenUfsBlockOptions() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions getOpenUfsBlockOptions() {
      if (openUfsBlockOptionsBuilder_ == null) {
        return openUfsBlockOptions_ == null ? alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.getDefaultInstance() : openUfsBlockOptions_;
      } else {
        return openUfsBlockOptionsBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public Builder setOpenUfsBlockOptions(alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions value) {
      if (openUfsBlockOptionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        openUfsBlockOptions_ = value;
        onChanged();
      } else {
        openUfsBlockOptionsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public Builder setOpenUfsBlockOptions(
        alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder builderForValue) {
      if (openUfsBlockOptionsBuilder_ == null) {
        openUfsBlockOptions_ = builderForValue.build();
        onChanged();
      } else {
        openUfsBlockOptionsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public Builder mergeOpenUfsBlockOptions(alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions value) {
      if (openUfsBlockOptionsBuilder_ == null) {
        if (((bitField0_ & 0x00000020) == 0x00000020) &&
            openUfsBlockOptions_ != null &&
            openUfsBlockOptions_ != alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.getDefaultInstance()) {
          openUfsBlockOptions_ =
            alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.newBuilder(openUfsBlockOptions_).mergeFrom(value).buildPartial();
        } else {
          openUfsBlockOptions_ = value;
        }
        onChanged();
      } else {
        openUfsBlockOptionsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000020;
      return this;
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public Builder clearOpenUfsBlockOptions() {
      if (openUfsBlockOptionsBuilder_ == null) {
        openUfsBlockOptions_ = null;
        onChanged();
      } else {
        openUfsBlockOptionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000020);
      return this;
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder getOpenUfsBlockOptionsBuilder() {
      bitField0_ |= 0x00000020;
      onChanged();
      return getOpenUfsBlockOptionsFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    public alluxio.proto.dataserver.Protocol.OpenUfsBlockOptionsOrBuilder getOpenUfsBlockOptionsOrBuilder() {
      if (openUfsBlockOptionsBuilder_ != null) {
        return openUfsBlockOptionsBuilder_.getMessageOrBuilder();
      } else {
        return openUfsBlockOptions_ == null ?
            alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.getDefaultInstance() : openUfsBlockOptions_;
      }
    }
    /**
     * <pre>
     * This is only set for UFS block read.
     * </pre>
     *
     * <code>optional .alluxio.proto.dataserver.OpenUfsBlockOptions open_ufs_block_options = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptionsOrBuilder> 
        getOpenUfsBlockOptionsFieldBuilder() {
      if (openUfsBlockOptionsBuilder_ == null) {
        openUfsBlockOptionsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptions.Builder, alluxio.proto.dataserver.Protocol.OpenUfsBlockOptionsOrBuilder>(
                getOpenUfsBlockOptions(),
                getParentForChildren(),
                isClean());
        openUfsBlockOptions_ = null;
      }
      return openUfsBlockOptionsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:alluxio.grpc.ReadRequest)
  }

  // @@protoc_insertion_point(class_scope:alluxio.grpc.ReadRequest)
  private static final alluxio.grpc.ReadRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new alluxio.grpc.ReadRequest();
  }

  public static alluxio.grpc.ReadRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ReadRequest>
      PARSER = new com.google.protobuf.AbstractParser<ReadRequest>() {
    public ReadRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ReadRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReadRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReadRequest> getParserForType() {
    return PARSER;
  }

  public alluxio.grpc.ReadRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
