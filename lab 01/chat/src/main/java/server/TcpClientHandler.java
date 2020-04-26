package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

import static java.lang.String.format;

public class TcpClientHandler extends Thread {
    private Socket clientSocket;
    private final UUID uuid;
    private final PrintWriter out;

    public TcpClientHandler(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.uuid = UUID.randomUUID();
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        Server.usersTcpThreads.put(uuid, this);
        System.out.println(format("client with id %s connected", uuid.toString()));
    }

    void sendMessage(String message) {
        try {
            out.println(message);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Your id is: " + uuid.toString());
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("received message by TCP: " + message);
                Server.sendMessageToAll(message, uuid);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}