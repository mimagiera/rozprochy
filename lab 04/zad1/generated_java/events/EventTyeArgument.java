// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: events.proto

package events;

/**
 * Protobuf type {@code events.EventTyeArgument}
 */
public  final class EventTyeArgument extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:events.EventTyeArgument)
    EventTyeArgumentOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EventTyeArgument.newBuilder() to construct.
  private EventTyeArgument(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EventTyeArgument() {
    eventType_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EventTyeArgument();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EventTyeArgument(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return events.EventsProto.internal_static_events_EventTyeArgument_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return events.EventsProto.internal_static_events_EventTyeArgument_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            events.EventTyeArgument.class, events.EventTyeArgument.Builder.class);
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
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof events.EventTyeArgument)) {
      return super.equals(obj);
    }
    events.EventTyeArgument other = (events.EventTyeArgument) obj;

    if (eventType_ != other.eventType_) return false;
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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static events.EventTyeArgument parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventTyeArgument parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventTyeArgument parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventTyeArgument parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventTyeArgument parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static events.EventTyeArgument parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static events.EventTyeArgument parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static events.EventTyeArgument parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static events.EventTyeArgument parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static events.EventTyeArgument parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static events.EventTyeArgument parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static events.EventTyeArgument parseFrom(
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
  public static Builder newBuilder(events.EventTyeArgument prototype) {
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
   * Protobuf type {@code events.EventTyeArgument}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:events.EventTyeArgument)
      events.EventTyeArgumentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return events.EventsProto.internal_static_events_EventTyeArgument_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return events.EventsProto.internal_static_events_EventTyeArgument_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              events.EventTyeArgument.class, events.EventTyeArgument.Builder.class);
    }

    // Construct using events.EventTyeArgument.newBuilder()
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

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return events.EventsProto.internal_static_events_EventTyeArgument_descriptor;
    }

    @java.lang.Override
    public events.EventTyeArgument getDefaultInstanceForType() {
      return events.EventTyeArgument.getDefaultInstance();
    }

    @java.lang.Override
    public events.EventTyeArgument build() {
      events.EventTyeArgument result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public events.EventTyeArgument buildPartial() {
      events.EventTyeArgument result = new events.EventTyeArgument(this);
      result.eventType_ = eventType_;
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
      if (other instanceof events.EventTyeArgument) {
        return mergeFrom((events.EventTyeArgument)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(events.EventTyeArgument other) {
      if (other == events.EventTyeArgument.getDefaultInstance()) return this;
      if (other.eventType_ != 0) {
        setEventTypeValue(other.getEventTypeValue());
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
      events.EventTyeArgument parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (events.EventTyeArgument) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

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


    // @@protoc_insertion_point(builder_scope:events.EventTyeArgument)
  }

  // @@protoc_insertion_point(class_scope:events.EventTyeArgument)
  private static final events.EventTyeArgument DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new events.EventTyeArgument();
  }

  public static events.EventTyeArgument getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EventTyeArgument>
      PARSER = new com.google.protobuf.AbstractParser<EventTyeArgument>() {
    @java.lang.Override
    public EventTyeArgument parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EventTyeArgument(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EventTyeArgument> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EventTyeArgument> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public events.EventTyeArgument getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

