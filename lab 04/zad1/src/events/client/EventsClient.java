package events.client;

import events.EventInfo;
import events.EventTyeArgument;
import events.EventType;
import events.EventsServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class EventsClient {
    private static final Logger logger = Logger.getLogger(EventsClient.class.getName());

    private final ManagedChannel channel;
    private final EventsServiceGrpc.EventsServiceStub calcNonBlockingStub;

    public EventsClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        calcNonBlockingStub = EventsServiceGrpc.newStub(channel);
    }

    public static void main(String[] args) throws Exception {
        EventsClient client = new EventsClient("localhost", 50051);
        client.start();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void start() throws InterruptedException {
        StreamObserver<EventInfo> responseObserver = getResponseObserver();
        try {
            String line = null;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            StreamObserver<EventTyeArgument> observer = null;
            do {
                try {
                    System.out.print("==> ");
                    System.out.flush();
                    line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.equals("subscribe")) {
                        logger.info(possibleEventsNames());
                        line = in.readLine();
                        EventType eventType = line.equals("a") ? EventType.FOOTBALL : EventType.BASKETBALL;

                        EventTyeArgument request = EventTyeArgument.newBuilder().setEventType(eventType).build();
                        if (observer == null)
                            observer = calcNonBlockingStub.subscribe(responseObserver);
                        observer.onNext(request);
                    }

                } catch (java.io.IOException ex) {
                    System.err.println(ex);
                }
            }
            while (!line.equals("x"));
        } finally {
            shutdown();
        }
    }

    public static String possibleEventsNames() {
        return Arrays.toString(EventType.class.getEnumConstants());
    }

    private StreamObserver<EventInfo> getResponseObserver() {
        return new StreamObserver<EventInfo>() {
            @Override
            public void onError(Throwable t) {
                logger.severe("gRPC ERROR");
            }

            @Override
            public void onCompleted() {
                logger.info("completed");
            }

            @Override
            public void onNext(EventInfo res) {
                logger.info(res.getEventType().name() + " " + res.getPrice() + " " + res.getArtistsList().toString());
            }
        };
    }
}
