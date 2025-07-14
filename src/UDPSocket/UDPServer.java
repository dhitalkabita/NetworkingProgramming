package UDPSocket;


import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Bind to port
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket); // Receive incoming packet

                String clientMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client says: " + clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Client ended the chat.");
                    break;
                }

                // Prepare reply
                String reply = "Server received: " + clientMsg;
                sendData = reply.getBytes();

                // Get client's IP and port
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket); // Send reply back to client
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
