import java.io.*;
import java.net.*;

public class Socket_Client {
    public static void main(String[] args) {
        String serverAddress = "192.168.1.228"; // Server IP address
        int port = 7058; // Server port number

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server.");

            // Set up the output stream to send data to the server
            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Enter data to send to the server (type 'exit' to quit):");
                String userInput;

                // Send data to the server repeatedly
                while ((userInput = userInputReader.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(userInput)) {
                        System.out.println("Exiting...");
                        break;
                    }
                    out.println(userInput); // Send user input to the server
                    System.out.println("Sent to server: " + userInput);
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Don't know about host: " + serverAddress);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to: " + serverAddress);
            e.printStackTrace();
        }
    }
}