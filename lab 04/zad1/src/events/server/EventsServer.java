package events.server;

import events.EventInfo;
import events.EventType;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;


public class EventsServer {
    private static final Logger logger = Logger.getLogger(EventsServer.class.getName());

    private static final int PORT = 50051;
    private final Server server;
    private final BlockingQueue<EventInfo> queue = new LinkedBlockingQueue<>();
    private final EventsSender eventsSender = new EventsSender(queue);

    EventsServer() {
        server = ServerBuilder.forPort(PORT)
                .addService(eventsSender)
                .build();
        logger.info("Server started, listening on " + PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            this.stop();
            System.err.println("*** server shut down");
        }));
    }

    void start() {
        try {
            new Thread(eventsSender).start();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    void sendMessage(int price) {
        EventType eventType = price > 5 ? EventType.FOOTBALL : EventType.BASKETBALL;
        EventInfo eventInfo = EventInfo.newBuilder().setEventType(eventType).setPrice(price)
                .addAllArtists(Arrays.asList("Ronaldo", "Messi")).build();
        queue.add(eventInfo);
    }

}
