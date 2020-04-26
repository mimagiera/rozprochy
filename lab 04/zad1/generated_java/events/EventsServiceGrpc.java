package events;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.0)",
    comments = "Source: events.proto")
public final class EventsServiceGrpc {

  private EventsServiceGrpc() {}

  public static final String SERVICE_NAME = "events.EventsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<events.EventTyeArgument,
      events.EventInfo> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = events.EventTyeArgument.class,
      responseType = events.EventInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<events.EventTyeArgument,
      events.EventInfo> getSubscribeMethod() {
    io.grpc.MethodDescriptor<events.EventTyeArgument, events.EventInfo> getSubscribeMethod;
    if ((getSubscribeMethod = EventsServiceGrpc.getSubscribeMethod) == null) {
      synchronized (EventsServiceGrpc.class) {
        if ((getSubscribeMethod = EventsServiceGrpc.getSubscribeMethod) == null) {
          EventsServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<events.EventTyeArgument, events.EventInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  events.EventTyeArgument.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  events.EventInfo.getDefaultInstance()))
              .setSchemaDescriptor(new EventsServiceMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsServiceStub>() {
        @java.lang.Override
        public EventsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsServiceStub(channel, callOptions);
        }
      };
    return EventsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsServiceBlockingStub>() {
        @java.lang.Override
        public EventsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsServiceBlockingStub(channel, callOptions);
        }
      };
    return EventsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsServiceFutureStub>() {
        @java.lang.Override
        public EventsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsServiceFutureStub(channel, callOptions);
        }
      };
    return EventsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EventsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<events.EventTyeArgument> subscribe(
        io.grpc.stub.StreamObserver<events.EventInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(getSubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                events.EventTyeArgument,
                events.EventInfo>(
                  this, METHODID_SUBSCRIBE)))
          .build();
    }
  }

  /**
   */
  public static final class EventsServiceStub extends io.grpc.stub.AbstractAsyncStub<EventsServiceStub> {
    private EventsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<events.EventTyeArgument> subscribe(
        io.grpc.stub.StreamObserver<events.EventInfo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class EventsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EventsServiceBlockingStub> {
    private EventsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class EventsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EventsServiceFutureStub> {
    private EventsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.subscribe(
              (io.grpc.stub.StreamObserver<events.EventInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EventsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return events.EventsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventsService");
    }
  }

  private static final class EventsServiceFileDescriptorSupplier
      extends EventsServiceBaseDescriptorSupplier {
    EventsServiceFileDescriptorSupplier() {}
  }

  private static final class EventsServiceMethodDescriptorSupplier
      extends EventsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EventsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventsServiceFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
