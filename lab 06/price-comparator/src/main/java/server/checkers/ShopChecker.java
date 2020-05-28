package server.checkers;

import akka.actor.ActorRef;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static akka.pattern.Patterns.ask;
import static server.Timeouts.shopTimeout;

public class ShopChecker {
    private List<ActorRef> shops;

    public ShopChecker(List<ActorRef> shops) {
        this.shops = shops;
    }

    public List<Future<Object>> askShopsForPrice(String productName) {
        return shops.stream()
                .map(shop -> ask(shop, productName, shopTimeout))
                .collect(Collectors.toList());
    }

    public List<Integer> waitForShopsPrice(List<Future<Object>> shopPrices) {
        return shopPrices.stream()
                .map(this::waitForSingleShopPrice)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Integer> waitForSingleShopPrice(Future<Object> price) {
        try {
            return Optional.of((int) Await.result(price, shopTimeout.duration()));
        } catch (InterruptedException e) {
            System.err.println("Error getting price from shop: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Timeout checking price in shop.");
        }
        return Optional.empty();
    }
}
