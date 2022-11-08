package no.ntnu.datakomm.group3.planthumidity.humidityReciever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HumidityServer {
    public static void run(){
        int humidityPort = 5555;
        System.out.println("Humidity-server> Starting on port: " + humidityPort);
        try {
            ServerSocket welcomeSocket = new ServerSocket(humidityPort);

            boolean running = true;
            while(running) {
                Socket clientSocket = welcomeSocket.accept();
                System.out.println("Humidity-server> New client connected");
                welcomeSocket.getInetAddress();

                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                outToClient.println("Humidity-server> Connected");

                BufferedReader inFromSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientMsg = inFromSocket.readLine();
                if (clientMsg != null){
                    System.out.println("Humidity-server> Client msg: "+ clientMsg);
                }

                try {
                    Thread.sleep(100 * 1000);

                } catch (InterruptedException e){
                    System.out.println("Humidity-server> Sleep interrupted");
                }
                System.out.println("Humidity-server> Closing client socket...");
                clientSocket.close();
            }

            System.out.println("Humidity-server> Server shutting down.");
            welcomeSocket.close();

        }catch (IOException e){
            System.out.println("Humidity-server> Could not open a listening socket: " + e.getMessage());
        }
        System.out.println("Humidity-server> Server done, exiting");
    }
}
