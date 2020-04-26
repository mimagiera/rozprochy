package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UdpClientHandler extends Thread {
    private final DatagramSocket datagramSocket;

    public UdpClientHandler(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        byte[] receiveBuffer = new byte[1024];
        while (true) {
            try {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                datagramSocket.receive(receivePacket);
                int userPort = receivePacket.getPort();
                InetAddress address = receivePacket.getAddress();
                Server.usersUdpPorts.add(userPort);
                String message = new String(receivePacket.getData());
                System.out.println("received message by UDP: " + message);

                sendMessageToAll(userPort, address, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void sendMessageToAll(int senderPort, InetAddress address, String message) {
        byte[] sendBuffer = message.getBytes();
        Server.usersUdpPorts.stream()
                .filter(portNumber -> !portNumber.equals(senderPort))
                .forEach(portNumber -> {
                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
                    try {
                        datagramSocket.send(sendPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
