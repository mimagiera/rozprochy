package server.actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import database.Request;

import java.util.Optional;

import static java.lang.String.format;

public class DatabaseSaverActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return new ReceiveBuilder()
                .match(String.class, productName -> {
                    Optional<Request> possibleRequest = ServerActor.databaseQueries.incrementRequest(productName);

                    String message = possibleRequest.map(request -> format("Counter for product %s: %d. ",
                            productName, request.getCounter()))
                            .orElse((format("Cannot find counter for product %s. ", productName)));

                    getSender().tell(message, getSelf());
                })
                .build();
    }
}
