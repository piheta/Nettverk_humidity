import java.io.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSClient {

    public void sendToBackend(String msg) {
        int serverPort = 5555;
        String serverName = "10.212.25.196";

        System.setProperty("javax.net.ssl.trustStore","myTrustStore.jts");
        System.setProperty("javax.net.ssl.trustStorePassword","var_trust_passwd");

        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket)sslsocketfactory.createSocket(serverName,serverPort);

            PrintWriter outToSocket = new PrintWriter(socket.getOutputStream(), true);
            outToSocket.println(msg);
            System.out.println("sending: " + msg);

            BufferedReader inFromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = inFromSocket.readLine();
            if (serverResponse != null){
                System.out.println("servers response: " + serverResponse);
            } else {

            }


            System.out.println("Closing socket...");
        } catch (IOException e){
            System.out.println("Could not establish a connection: " + e.getMessage());
        }

        System.out.println("done");
    }
}
