package Socket;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        
        Thread serverThread = new Thread(()-> {
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
        });

     
        Thread clientThread = new Thread(() -> {
            try {
               
                Thread.sleep(1000);

                try (Socket socket = new Socket("localhost", 12345)) {
                    System.out.println("Connected to the server.");

                    // Set up output stream
                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

                        System.out.println("Enter data to send to the server (type 'exit' to quit):");
                        String userInput;
                        
                        while ((userInput = in.readLine()) != null) {
                            if ("exit".equalsIgnoreCase(userInput)) {
                                break;
                            }
                            out.println(userInput);
                        }
                    }
                }
            } catch (UnknownHostException e) {
                System.out.println("Don't know about host: localhost");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Couldn't get I/O for the connection to: localhost");
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

      
        serverThread.start();
        clientThread.start();
    }
}