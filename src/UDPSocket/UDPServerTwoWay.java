package UDPSocket;

import java.net.*;
import java.util.Scanner;

public class UDPServerTwoWay {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;
            Scanner scanner = new Scanner(System.in);

            System.out.println("UDP Server is running...");

            while (true) {
                // Receive packet from client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);
                String clientMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client says: " + clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client terminated the chat.");
                    break;
                }

                // Get server message from user input
                System.out.print("Server: ");
                String serverMsg = scanner.nextLine();
                sendBuffer = serverMsg.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Send message back to client
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server terminated the chat.");
                    break;
                }
            }
            serverSocket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
