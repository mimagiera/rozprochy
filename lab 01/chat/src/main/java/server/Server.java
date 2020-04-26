package server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

public class Server {
    static Map<UUID, TcpClientHandler> usersTcpThreads = new ConcurrentHashMap<>();
    static Set<Integer> usersUdpPorts = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) throws IOException {

        System.out.println("SERVER STARTED");
        int portNumber = 54321;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        DatagramSocket datagramSocket = new DatagramSocket(portNumber);
        new UdpClientHandler(datagramSocket).start();
        while (true) {
            new TcpClientHandler(serverSocket.accept()).start();
        }
    }

    static void sendMessageToAll(String message, UUID senderUUID) {
        usersTcpThreads.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(senderUUID))
                .forEach(entry -> {
                    entry.getValue().sendMessage(format("[From: %s] %s", senderUUID, message));
                });
    }

}
