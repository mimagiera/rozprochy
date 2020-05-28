package server.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.concurrent.Future;
import server.checkers.DatabaseChecker;
import server.checkers.ShopChecker;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static server.actors.ServerActor.shops;

public class ServerHelperActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    private final ShopChecker shopChecker;
    private final DatabaseChecker databaseChecker;
    private final ActorRef databaseSaverActor;

    public ServerHelperActor() {
        this.databaseSaverActor = context().actorOf(Props.create(DatabaseSaverActor.class));

        this.shopChecker = new ShopChecker(shops);
        this.databaseChecker = new DatabaseChecker(databaseSaverActor);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s -> {
                    if (s.startsWith("price")) {
                        String message = handleRequest(s);
                        stopDatabaseActor();
                        log.info("Sending message: \"{}\" from {} to {}", message, getSelf(), getSender());
                        getSender().tell(message, getSelf());

                    }
                })
                .build();
    }

    private void stopDatabaseActor() {
        context().stop(databaseSaverActor);
    }

    private String handleRequest(String inComingMessage) {
        String[] request = inComingMessage.split("\\s");
        if (request.length < 2) {
            return "Product name not specified";
        } else {
            String productName = getProductName(request);

            List<Future<Object>> shopPrices = shopChecker.askShopsForPrice(productName);
            Future<Object> responseFromDatabase = databaseChecker.askDatabaseForMessage(productName);

            return waitForOutgoingMessage(shopPrices, responseFromDatabase, productName);
        }
    }

    private String waitForOutgoingMessage(List<Future<Object>> shopPrices, Future<Object> responseFromDatabase,
                                          String productName) {
        List<Integer> prices = shopChecker.waitForShopsPrice(shopPrices);
        String messageFromDatabase = databaseChecker.waitForMessageFromDatabase(responseFromDatabase);

        String priceMessage = createPriceMessage(prices, productName);

        return messageFromDatabase + priceMessage;
    }


    private String createPriceMessage(List<Integer> prices, String productName) {
        Optional<Integer> possiblePrice = prices.stream()
                .min(Integer::compare);

        return possiblePrice.map(price -> format("Price for product %s equals: %d. ", productName, price))
                .orElse(format("No price for product %s found. ", productName));
    }


    private String getProductName(String[] request) {
        String[] modifiedArray = Arrays.copyOfRange(request, 1, request.length);
        return String.join(" ", modifiedArray);
    }
}
