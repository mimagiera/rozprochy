package events.server;

import java.io.IOException;

public class MainServer {
    static final EventsServer server = new EventsServer();

    public static void main(String[] args) throws InterruptedException {
        server.start();
        sendMessages().start();
        server.blockUntilShutdown();
    }


    static Thread sendMessages() {
        return new Thread(() -> {
            String line;
            int message;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.print("==> ");

            while (true) {
                try {
                    line = in.readLine();
                    try {
                        message = Integer.parseInt(line);
                        server.sendMessage(message);
                    } catch (Exception ignored) {
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
