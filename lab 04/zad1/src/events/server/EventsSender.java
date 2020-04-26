package events.server;

import events.EventInfo;
import events.EventTyeArgument;
import events.EventType;
import events.EventsServiceGrpc;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class EventsSender extends EventsServiceGrpc.EventsServiceImplBase implements Runnable {
    private static final Logger logger = Logger.getLogger(EventsSender.class.getName());

    private final BlockingQueue<EventInfo> queue;

    private final Map<EventType, Set<StreamObserver<EventInfo>>> observers = new ConcurrentHashMap<>();

    public EventsSender(BlockingQueue<EventInfo> queue) {
        this.queue = queue;
    }

    @Override
    public StreamObserver<EventTyeArgument> subscribe(StreamObserver<EventInfo> responseObserver) {
        return new StreamObserver<EventTyeArgument>() {
            @Override
            public void onNext(EventTyeArgument eventTyeArgument) {
                EventType eventType = eventTyeArgument.getEventType();
                logger.info("New subscriber for type: " + eventType);
                observers.computeIfAbsent(eventType, k -> new HashSet<>()).add(responseObserver);
                Context.current().addListener(context -> logger.info("listener"),
                        command -> {
                            logger.info("Removing observer");
                            Optional.ofNullable(observers.get(eventType))
                                    .ifPresent(streamObservers -> streamObservers.remove(responseObserver));
                        });
            }

            @Override
            public void onError(Throwable throwable) {
                logger.severe("whoooops");
            }

            @Override
            public void onCompleted() {
            }
        };
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // waiting for first element
                EventInfo eventInfo = queue.take();
                logger.info("New info to send: " + eventInfo);

                Optional.ofNullable(observers.get(eventInfo.getEventType()))
                        .ifPresent(streamObservers -> streamObservers.forEach(o -> o.onNext(eventInfo)));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
