package server;

import akka.util.Timeout;

import java.time.Duration;

public class Timeouts {
    public static final Timeout helperTimeout = Timeout.create(Duration.ofMinutes(1));

    public static final Timeout databaseTimeout = Timeout.create(Duration.ofMillis(900));

    public static final Timeout shopTimeout = Timeout.create(Duration.ofMillis(300));
}
