package Socket;

import java.io.*;
import java.net.*;

public class Socket_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for connections...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected.");

                // Set up input stream
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    String inputLine;
                    // Read and print data from the client
                    while ((inputLine = in.readLine()) != null) {
                    	
                        System.out.println("Received from client: " + inputLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}