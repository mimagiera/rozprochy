// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: events.proto

package events;

/**
 * Protobuf type {@code events.EventInfo}
 */
public  final class EventInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:events.EventInfo)
    EventInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EventInfo.newBuilder() to construct.
  private EventInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EventInfo() {
    eventType_ = 0;
    artists_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EventInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EventInfo(
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
          case 8: {
            int rawValue = input.readEnum();

            eventType_ = rawValue;
            break;
          }
          case 16: {

            price_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              artists_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            artists_.add(s);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        artists_ = artists_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return events.EventsProto.internal_static_events_EventInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return events.EventsProto.internal_static_events_EventInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            events.EventInfo.class, events.EventInfo.Builder.class);
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 1;
  private int eventType_;
  /**
   * <code>.events.EventType eventType = 1;</code>
   * @return The enum numeric value on the wire for eventType.
   */
  public int getEventTypeValue() {
    return eventType_;
  }
  /**
   * <code>.events.EventType eventType = 1;</code>
   * @return The eventType.
   */
  public events.EventType getEventType() {
    @SuppressWarnings("deprecation")
    events.EventType result = events.EventType.valueOf(eventType_);
    return result == null ? events.EventType.UNRECOGNIZED : result;
  }

  public static final int PRICE_FIELD_NUMBER = 2;
  private int price_;
  /**
   * <code>int32 price = 2;</code>
   * @return The price.
   */
  public int getPrice() {
    return price_;
  }

  public static final int ARTISTS_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList artists_;
  /**
   * <code>repeated string artists = 3;</code>
   * @return A list containing the artists.
   */
  public com.google.protobuf.ProtocolStringList
      getArtistsList() {
    return artists_;
  }
  /**
   * <code>repeated string artists = 3;</code>
   * @return The count of artists.
   */
  public int getArtistsCount() {
    return artists_.size();
  }
  /**
   * <code>repeated string artists = 3;</code>
   * @param index The index of the element to return.
   * @return The artists at the given index.
   */
  public java.lang.String getArtists(int index) {
    return artists_.get(index);
  }
  /**
   * <code>repeated string artists = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the artists at the given index.
   */
  public com.google.protobuf.ByteString
      getArtistsBytes(int index) {
    return artists_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (eventType_ != events.EventType.FOOTBALL.getNumber()) {
      output.writeEnum(1, eventType_);
    }
    if (price_ != 0) {
      output.writeInt32(2, price_);
    }
    for (int i = 0; i < artists_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, artists_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (eventType_ != events.EventType.FOOTBALL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, eventType_);
    }
    if (price_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, price_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < artists_.size(); i++) {
        dataSize += computeStringSizeNoTag(artists_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getArtistsList().size();
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
    if (!(obj instanceof events.EventInfo)) {
      return super.equals(obj);
    }
    events.EventInfo other = (events.EventInfo) obj;

    if (eventType_ != other.eventType_) return false;
    if (getPrice()
        != other.getPrice()) return false;
    if (!getArtistsList()
        .equals(other.getArtistsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EVENTTYPE_FIELD_NUMBER;
    hash = (53 * hash) + eventType_;
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + getPrice();
    if (getArtistsCount() > 0) {
      hash = (37 * hash) + ARTISTS_FIELD_NUMBER;
      hash = (53 * hash) + getArtistsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static events.EventInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static events.EventInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static events.EventInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static events.EventInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static events.EventInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static events.EventInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(events.EventInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code events.EventInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:events.EventInfo)
      events.EventInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return events.EventsProto.internal_static_events_EventInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return events.EventsProto.internal_static_events_EventInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              events.EventInfo.class, events.EventInfo.Builder.class);
    }

    // Construct using events.EventInfo.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      eventType_ = 0;

      price_ = 0;

      artists_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return events.EventsProto.internal_static_events_EventInfo_descriptor;
    }

    @java.lang.Override
    public events.EventInfo getDefaultInstanceForType() {
      return events.EventInfo.getDefaultInstance();
    }

    @java.lang.Override
    public events.EventInfo build() {
      events.EventInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public events.EventInfo buildPartial() {
      events.EventInfo result = new events.EventInfo(this);
      int from_bitField0_ = bitField0_;
      result.eventType_ = eventType_;
      result.price_ = price_;
      if (((bitField0_ & 0x00000001) != 0)) {
        artists_ = artists_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.artists_ = artists_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof events.EventInfo) {
        return mergeFrom((events.EventInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(events.EventInfo other) {
      if (other == events.EventInfo.getDefaultInstance()) return this;
      if (other.eventType_ != 0) {
        setEventTypeValue(other.getEventTypeValue());
      }
      if (other.getPrice() != 0) {
        setPrice(other.getPrice());
      }
      if (!other.artists_.isEmpty()) {
        if (artists_.isEmpty()) {
          artists_ = other.artists_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureArtistsIsMutable();
          artists_.addAll(other.artists_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      events.EventInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (events.EventInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int eventType_ = 0;
    /**
     * <code>.events.EventType eventType = 1;</code>
     * @return The enum numeric value on the wire for eventType.
     */
    public int getEventTypeValue() {
      return eventType_;
    }
    /**
     * <code>.events.EventType eventType = 1;</code>
     * @param value The enum numeric value on the wire for eventType to set.
     * @return This builder for chaining.
     */
    public Builder setEventTypeValue(int value) {
      eventType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.events.EventType eventType = 1;</code>
     * @return The eventType.
     */
    public events.EventType getEventType() {
      @SuppressWarnings("deprecation")
      events.EventType result = events.EventType.valueOf(eventType_);
      return result == null ? events.EventType.UNRECOGNIZED : result;
    }
    /**
     * <code>.events.EventType eventType = 1;</code>
     * @param value The eventType to set.
     * @return This builder for chaining.
     */
    public Builder setEventType(events.EventType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      eventType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.events.EventType eventType = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearEventType() {
      
      eventType_ = 0;
      onChanged();
      return this;
    }

    private int price_ ;
    /**
     * <code>int32 price = 2;</code>
     * @return The price.
     */
    public int getPrice() {
      return price_;
    }
    /**
     * <code>int32 price = 2;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(int value) {
      
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 price = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      
      price_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList artists_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureArtistsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        artists_ = new com.google.protobuf.LazyStringArrayList(artists_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @return A list containing the artists.
     */
    public com.google.protobuf.ProtocolStringList
        getArtistsList() {
      return artists_.getUnmodifiableView();
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @return The count of artists.
     */
    public int getArtistsCount() {
      return artists_.size();
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param index The index of the element to return.
     * @return The artists at the given index.
     */
    public java.lang.String getArtists(int index) {
      return artists_.get(index);
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the artists at the given index.
     */
    public com.google.protobuf.ByteString
        getArtistsBytes(int index) {
      return artists_.getByteString(index);
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param index The index to set the value at.
     * @param value The artists to set.
     * @return This builder for chaining.
     */
    public Builder setArtists(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureArtistsIsMutable();
      artists_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param value The artists to add.
     * @return This builder for chaining.
     */
    public Builder addArtists(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureArtistsIsMutable();
      artists_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param values The artists to add.
     * @return This builder for chaining.
     */
    public Builder addAllArtists(
        java.lang.Iterable<java.lang.String> values) {
      ensureArtistsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, artists_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearArtists() {
      artists_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string artists = 3;</code>
     * @param value The bytes of the artists to add.
     * @return This builder for chaining.
     */
    public Builder addArtistsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureArtistsIsMutable();
      artists_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:events.EventInfo)
  }

  // @@protoc_insertion_point(class_scope:events.EventInfo)
  private static final events.EventInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new events.EventInfo();
  }

  public static events.EventInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EventInfo>
      PARSER = new com.google.protobuf.AbstractParser<EventInfo>() {
    @java.lang.Override
    public EventInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EventInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EventInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EventInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public events.EventInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

