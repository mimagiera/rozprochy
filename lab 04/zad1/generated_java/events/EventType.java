// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: events.proto

package events;

/**
 * Protobuf enum {@code events.EventType}
 */
public enum EventType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>FOOTBALL = 0;</code>
   */
  FOOTBALL(0),
  /**
   * <code>CONCERT = 1;</code>
   */
  CONCERT(1),
  /**
   * <code>BASKETBALL = 2;</code>
   */
  BASKETBALL(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>FOOTBALL = 0;</code>
   */
  public static final int FOOTBALL_VALUE = 0;
  /**
   * <code>CONCERT = 1;</code>
   */
  public static final int CONCERT_VALUE = 1;
  /**
   * <code>BASKETBALL = 2;</code>
   */
  public static final int BASKETBALL_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EventType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EventType forNumber(int value) {
    switch (value) {
      case 0: return FOOTBALL;
      case 1: return CONCERT;
      case 2: return BASKETBALL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EventType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EventType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EventType>() {
          public EventType findValueByNumber(int number) {
            return EventType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return events.EventsProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final EventType[] VALUES = values();

  public static EventType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EventType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:events.EventType)
}

