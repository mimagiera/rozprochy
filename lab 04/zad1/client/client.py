from __future__ import print_function

import sys

import grpc

sys.path.insert(1, '../generated_python')

from events_pb2_grpc import EventsServiceStub
from events_pb2 import *


def generate_messages():
    messages = [
        EventTyeArgument(eventType=EventType.FOOTBALL),
        EventTyeArgument(eventType=EventType.CONCERT)
    ]
    for msg in messages:
        print("Sending %s" % (msg))
        yield msg


def events_listen(stub):
    responses = stub.Subscribe(generate_messages())
    for response in responses:
        print("Received message. Event type: %s, price: %s, artists: %s" %
              (response.eventType, response.price, response.artists))


def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = EventsServiceStub(channel)
        print("-------------- events_listen --------------")
        events_listen(stub)


run()
