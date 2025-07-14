package TCPSocket;
import java.io.*;
import java.net.*;
//Two-Way Socket Programming in Java (Communication is bi-directional.)
// TCP (Transmission Control Protocol) - StreamSocket
//TCP requires a connection to be established first (accept()) and then data is sent reliably.(Connection-oriented)
// code explicitly waits for a connection using serverSocket.accept(), which is a TCP behavior.
//Messages are exchanged in a sequential, reliable manner.(Reliable communication)
public class SocClient2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("Connected to server.");

        // Setup input and output streams
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(), true);
        ///To send data/messages to the other side of the socket via the output stream.

        // To send from client (keyboard input)
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
//To read incoming data/messages from the other side of the socket.
// Usually wrapped around an InputStreamReader connected to the socket's input stream.

        String clientMsg, serverMsg;

        while (true) {
            // Send to server
            System.out.print("Client: ");
            clientMsg = keyboard.readLine();   // Read input from client keyboard
            clientOutput.println(clientMsg); // Send the message to the server

            if (clientMsg.equalsIgnoreCase("exit")) { // If client types "exit", break the loop to end the chat
                break;
            }

            // Receive from server
            serverMsg = serverInput.readLine(); //Wait to receive the server’s response
            if (serverMsg.equalsIgnoreCase("exit")) {  //If server sends "exit" (or closes), notify client and exit loop
                System.out.println("Server ended the chat.");
                break;
            }

            System.out.println("Server: " + serverMsg); // Print the server's response on client console
        }

        socket.close();
    }
}
