package Socket;

import java.io.*;
import java.net.*;

public class Connect_Server {
    public static void main(String[] args) 
    {
    	
//    	conn=databaseConnection();
//    	if(conn.isConnected) {
//    		
//    	compositeNsame=	parser(rtuData);
//    		isExsit= checkDeviceCredentials(compositeNsame);
//    		
//    		if(isExist)
//    		{
//    			sout()
//    		}
//    		else 
//    		{
//    			
//    			
//    		}
//    	
//    		
//    	}
    	
    	
    	
    	
    	
    	
        String serverAddress = "192.168.1.228"; 
        int port =7058 ; 

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server at " + serverAddress + " on port " + port);
            try(PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            	BufferedReader consoleIn= new BufferedReader(new InputStreamReader(System.in));
            	BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
        
             System.out.println("Enter data to send to the server (type 'exit' to quit):");
                String userInput;
                
                // Thread to handle server messages
                Thread serverHandler = new Thread(() -> {
                    String serverMessage;
                    try {
                        while ((serverMessage = serverIn.readLine()) != null) {
                            System.out.println("Server: " + serverMessage);
                        }
                    } catch (IOException e) {
                        System.out.println("Server connection closed");
                    }
                });
                serverHandler.start();

                // Send data to the server repeatedly
                while ((userInput = consoleIn.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(userInput)) {
                        break;
                    }
                    out.println(userInput);
                }

                // Close the socket and exit
             //   socket.close();
                System.out.println("Connection closed.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + serverAddress);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error for the connection to: " + serverAddress);
            e.printStackTrace();
        }
    }
}