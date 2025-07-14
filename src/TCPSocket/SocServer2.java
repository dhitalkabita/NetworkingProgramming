package TCPSocket;

import java.io.*;
import java.net.*;
/////Two-Way Socket Programming in Java (Communication is bi-directional.)
public class SocServer2 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Setup input and output streams
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //to read incoming messages from the client through the socket's input stream.
        PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
//to the client via the socket's output stream.

        // To send from server (keyboard input)
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//Wraps InputStreamReader inside BufferedReader for efficient reading, especially useful for reading lines of text.
        String clientMsg, serverMsg;

        while (true) {
            // Receive from client
            clientMsg = clientInput.readLine(); // Wait to receive a message from the client
            if (clientMsg.equalsIgnoreCase("exit")) {
                System.out.println("Client ended the chat.");
                break;
            }
            System.out.println("Client: " + clientMsg);

            // Send to client
            System.out.print("Server: ");
            serverMsg = keyboard.readLine(); //Prompt the server user to type a reply
            serverOutput.println(serverMsg);

            if (serverMsg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
        serverSocket.close();
    }
}
