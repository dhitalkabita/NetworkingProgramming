package UDPSocket;

import java.net.*;
import java.util.Scanner;

public class UDPClientTwoWay {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost"); // or IP of server
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            System.out.println("UDP Client is running...");

            while (true) {
                // Get client message from user input
                System.out.print("Client: ");
                String clientMsg = scanner.nextLine();
                sendBuffer = clientMsg.getBytes();

                // Send message to server
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
                clientSocket.send(sendPacket);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client terminated the chat.");
                    break;
                }

                // Receive response from server
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);
                String serverMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server says: " + serverMsg);

                if (serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server terminated the chat.");
                    break;
                }
            }
            clientSocket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
