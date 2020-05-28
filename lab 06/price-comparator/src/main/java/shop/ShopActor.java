package shop;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Random;

public class ShopActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s -> getSender().tell(calculatePrice(), getSelf()))
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }

    private int calculatePrice() throws InterruptedException {
        Thread.sleep(new Random().nextInt(400) + 100);
        return new Random().nextInt(9) + 1;
    }
}
