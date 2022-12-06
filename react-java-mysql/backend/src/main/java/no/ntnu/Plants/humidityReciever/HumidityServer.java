package no.ntnu.Plants.humidityReciever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.net.ssl.SSLSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no.ntnu.Plants.service.HumidityService;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HumidityServer extends Thread {

    private boolean isRunning = true;

    @Autowired
    private HumidityService hs;

    public void run(){
        int port = 5555;
        Logger logger = Logger.getLogger(HumidityServer.class.getName());
        String logStarting = "Humidity-server> Started on port: " + Integer.toString(port);
        logger.log(Level.INFO, logStarting);

        System.setProperty("javax.net.ssl.keyStore","Group3KeyStore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","var_keystore_passwd"); //env var

        try{
            SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket)sslServerSocketfactory.createServerSocket(port);

            while(isRunning) {
                //create socket
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                logger.log(Level.INFO, "Humidity-server> New client connected");
                sslServerSocket.getInetAddress();

                //message printed on client screen after connection
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                outToClient.println('\n' + "Humidity-server> Connected");

                /*
                 * Expected string: "${plantId};${humidity}" == "1;50"
                 */
                BufferedReader inFromSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientMsg = inFromSocket.readLine();
                if (clientMsg != null){
                    System.out.println(clientMsg);
                    int plantId1 = Integer.parseInt(clientMsg.split(";")[0]);
                    int humidityPercent1 = Integer.parseInt(clientMsg.split(";")[1]);
                    int plantId2 = Integer.parseInt(clientMsg.split(";")[2]);
                    int humidityPercent2 = Integer.parseInt(clientMsg.split(";")[3]);
                    int plantId3 = Integer.parseInt(clientMsg.split(";")[4]);
                    int humidityPercent3 = Integer.parseInt(clientMsg.split(";")[5]);


                    hs.addHumidity(plantId1,humidityPercent1);
                    hs.addHumidity(plantId2,humidityPercent2);
                    hs.addHumidity(plantId3,humidityPercent3);
                }


                try {
                    Thread.sleep(1500); //3s
                } catch (InterruptedException e){
                    logger.log(Level.WARNING, e.getMessage());
                    logger.log(Level.WARNING, "Humidity-server> Sleep interrupted");
                }



                logger.log(Level.INFO, "Humidity-server> Client socket closed");
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
