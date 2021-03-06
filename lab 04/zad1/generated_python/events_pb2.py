# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: events.proto

from google.protobuf.internal import enum_type_wrapper
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='events.proto',
  package='events',
  syntax='proto3',
  serialized_options=b'\n\006eventsB\013EventsProtoP\001',
  serialized_pb=b'\n\x0c\x65vents.proto\x12\x06\x65vents\"3\n\x15\x41rithmeticOpArguments\x12\x0c\n\x04\x61rg1\x18\x01 \x01(\x05\x12\x0c\n\x04\x61rg2\x18\x02 \x01(\x05\"Q\n\tEventInfo\x12$\n\teventType\x18\x01 \x01(\x0e\x32\x11.events.EventType\x12\r\n\x05price\x18\x02 \x01(\x05\x12\x0f\n\x07\x61rtists\x18\x03 \x03(\t\"8\n\x10\x45ventTyeArgument\x12$\n\teventType\x18\x01 \x01(\x0e\x32\x11.events.EventType*6\n\tEventType\x12\x0c\n\x08\x46OOTBALL\x10\x00\x12\x0b\n\x07\x43ONCERT\x10\x01\x12\x0e\n\nBASKETBALL\x10\x02\x32O\n\rEventsService\x12>\n\tSubscribe\x12\x18.events.EventTyeArgument\x1a\x11.events.EventInfo\"\x00(\x01\x30\x01\x42\x17\n\x06\x65ventsB\x0b\x45ventsProtoP\x01\x62\x06proto3'
)

_EVENTTYPE = _descriptor.EnumDescriptor(
  name='EventType',
  full_name='events.EventType',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='FOOTBALL', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='CONCERT', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='BASKETBALL', index=2, number=2,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=218,
  serialized_end=272,
)
_sym_db.RegisterEnumDescriptor(_EVENTTYPE)

EventType = enum_type_wrapper.EnumTypeWrapper(_EVENTTYPE)
FOOTBALL = 0
CONCERT = 1
BASKETBALL = 2



_ARITHMETICOPARGUMENTS = _descriptor.Descriptor(
  name='ArithmeticOpArguments',
  full_name='events.ArithmeticOpArguments',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='arg1', full_name='events.ArithmeticOpArguments.arg1', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='arg2', full_name='events.ArithmeticOpArguments.arg2', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=24,
  serialized_end=75,
)


_EVENTINFO = _descriptor.Descriptor(
  name='EventInfo',
  full_name='events.EventInfo',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='eventType', full_name='events.EventInfo.eventType', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='price', full_name='events.EventInfo.price', index=1,
      number=2, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='artists', full_name='events.EventInfo.artists', index=2,
      number=3, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=77,
  serialized_end=158,
)


_EVENTTYEARGUMENT = _descriptor.Descriptor(
  name='EventTyeArgument',
  full_name='events.EventTyeArgument',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='eventType', full_name='events.EventTyeArgument.eventType', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=160,
  serialized_end=216,
)

_EVENTINFO.fields_by_name['eventType'].enum_type = _EVENTTYPE
_EVENTTYEARGUMENT.fields_by_name['eventType'].enum_type = _EVENTTYPE
DESCRIPTOR.message_types_by_name['ArithmeticOpArguments'] = _ARITHMETICOPARGUMENTS
DESCRIPTOR.message_types_by_name['EventInfo'] = _EVENTINFO
DESCRIPTOR.message_types_by_name['EventTyeArgument'] = _EVENTTYEARGUMENT
DESCRIPTOR.enum_types_by_name['EventType'] = _EVENTTYPE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

ArithmeticOpArguments = _reflection.GeneratedProtocolMessageType('ArithmeticOpArguments', (_message.Message,), {
  'DESCRIPTOR' : _ARITHMETICOPARGUMENTS,
  '__module__' : 'events_pb2'
  # @@protoc_insertion_point(class_scope:events.ArithmeticOpArguments)
  })
_sym_db.RegisterMessage(ArithmeticOpArguments)

EventInfo = _reflection.GeneratedProtocolMessageType('EventInfo', (_message.Message,), {
  'DESCRIPTOR' : _EVENTINFO,
  '__module__' : 'events_pb2'
  # @@protoc_insertion_point(class_scope:events.EventInfo)
  })
_sym_db.RegisterMessage(EventInfo)

EventTyeArgument = _reflection.GeneratedProtocolMessageType('EventTyeArgument', (_message.Message,), {
  'DESCRIPTOR' : _EVENTTYEARGUMENT,
  '__module__' : 'events_pb2'
  # @@protoc_insertion_point(class_scope:events.EventTyeArgument)
  })
_sym_db.RegisterMessage(EventTyeArgument)


DESCRIPTOR._options = None

_EVENTSSERVICE = _descriptor.ServiceDescriptor(
  name='EventsService',
  full_name='events.EventsService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=274,
  serialized_end=353,
  methods=[
  _descriptor.MethodDescriptor(
    name='Subscribe',
    full_name='events.EventsService.Subscribe',
    index=0,
    containing_service=None,
    input_type=_EVENTTYEARGUMENT,
    output_type=_EVENTINFO,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_EVENTSSERVICE)

DESCRIPTOR.services_by_name['EventsService'] = _EVENTSSERVICE

# @@protoc_insertion_point(module_scope)
