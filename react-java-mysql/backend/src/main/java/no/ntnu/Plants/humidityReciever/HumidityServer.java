package no.ntnu.Plants.humidityReciever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HumidityServer {

    static boolean isRunning = true;
    private HumidityServer(){}
    
    public static void run(int humidityPort){
        Logger logger = Logger.getLogger(HumidityServer.class.getName());
        String logStarting = "Humidity-server> Starting on port: " + Integer.toString(humidityPort);
        logger.log(Level.INFO, logStarting);

        System.setProperty("javax.net.ssl.keyStore","myKeyStore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword",""); //env var

        try{
            SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket)sslServerSocketfactory.createServerSocket(humidityPort);

            while(isRunning) {
                //create socket
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                logger.log(Level.INFO, "Humidity-server> New client connected");
                sslServerSocket.getInetAddress();

                //message printed on client screen after connection
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                outToClient.println('\n' + "Humidity-server> Connected");

                /*
                 * Expected decoded string: "${plantId};${humidity}" == "1,50"
                 */
                BufferedReader inFromSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientMsg = inFromSocket.readLine();
                if (clientMsg != null){
                    //ToDo implement encoding and decoding of messages
                    System.out.println(clientMsg);
                    //Todo implement sql adder of above string
                }


                try {
                    Thread.sleep(3000); //3s
                } catch (InterruptedException e){
                    logger.log(Level.WARNING, e.getMessage());
                    logger.log(Level.WARNING, "Humidity-server> Sleep interrupted");
                }



                logger.log(Level.INFO, "Humidity-server> Closing client socket...");
                clientSocket.close();
            }
            logger.log(Level.INFO, "Humidity-server> Shutting down...");
            sslServerSocket.close();

        }catch (IOException e){
            logger.log(Level.SEVERE, "Humidity-server> Could not open a listening socket");
            logger.log(Level.SEVERE, e.getMessage());
        }
        logger.log(Level.INFO, "Humidity-server> Server done, exiting");
    }
}