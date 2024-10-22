// Server.java
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started, waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read and send messages
            String message = "";
            while (!message.equals("exit")) {
                message = input.readUTF(); // Read message from client
                System.out.println("Client: " + message);

                // Reply to client
                output.writeUTF("Server received: " + message);
                output.flush();
            }

            // Close connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
