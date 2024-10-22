import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost, port 5000
            Socket socket = new Socket("localhost", 5000);

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String message = "";
            while (!message.equals("exit")) {
                System.out.print("Enter message: ");
                message = reader.readLine(); // Read message from the console

                // Send message to server
                output.writeUTF(message);
                output.flush();

                // Receive and print server's response
                String serverMessage = input.readUTF();
                System.out.println(serverMessage);
            }

            // Close connections
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
