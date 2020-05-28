package server.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.dispatch.OnComplete;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import database.DatabaseConnection;
import database.DatabaseQueries;
import scala.concurrent.Future;
import shop.ShopActor;

import java.util.ArrayList;
import java.util.List;

import static akka.pattern.Patterns.ask;
import static server.Timeouts.helperTimeout;

public class ServerActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static List<ActorRef> shops = new ArrayList<>();
    private static DatabaseConnection databaseConnection = new DatabaseConnection();
    static DatabaseQueries databaseQueries = new DatabaseQueries(databaseConnection.getConnection());

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s -> {
                    if (s.startsWith("price")) {
                        handlePriceRequest(s);
                    } else {
                        receivedUnknownMessage(s);
                    }
                })
                .matchAny(this::receivedUnknownMessage)
                .build();
    }

    private void receivedUnknownMessage(Object s) {
        log.info("Received unknown message: {}", s);
    }

    private void handlePriceRequest(String outGoingMessage) {
        ActorRef priceCheckerActor = context().actorOf(Props.create(ServerHelperActor.class));
        Future<Object> message = ask(priceCheckerActor, outGoingMessage, helperTimeout);

        message.onComplete(new OnComplete<Object>() {
                               @Override
                               public void onComplete(Throwable failure, Object success) {
                                   if (success != null) {
                                       log.info("Success: {}", success);
//                                       getSender().tell(success, getSelf());
                                   }
                                   if (failure != null) {
                                       log.error("Failure: {}", failure);
                                   }
                                   context().stop(priceCheckerActor);
                               }
                           }, context().dispatcher()
        );
    }

    @Override
    public void preStart() {
        shops.add(context().actorOf(Props.create(ShopActor.class), "biedronka"));
        shops.add(context().actorOf(Props.create(ShopActor.class), "tesco"));
    }

    @Override
    public void postStop() {
        databaseConnection.closeConnection();
    }
}
