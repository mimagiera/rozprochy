package server.checkers;

import akka.actor.ActorRef;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.util.concurrent.TimeoutException;

import static akka.pattern.Patterns.ask;
import static server.Timeouts.databaseTimeout;

public class DatabaseChecker {

    private final ActorRef databaseSaverActor;

    public DatabaseChecker(ActorRef databaseSaverActor) {
        this.databaseSaverActor = databaseSaverActor;
    }

    public String waitForMessageFromDatabase(Future<Object> responseFromDatabase) {
        try {
            return ((String) Await.result(responseFromDatabase, databaseTimeout.duration()));
        } catch (InterruptedException e) {
            return "Error getting info from database. " + e.getMessage();
        } catch (TimeoutException e) {
            return "Timeout getting info from database. ";
        }
    }

    public Future<Object> askDatabaseForMessage(String productName) {
        return ask(databaseSaverActor, productName, databaseTimeout);
    }
}
