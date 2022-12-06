import java.util.Random;

import static java.lang.Thread.sleep;

public class DataEmulator {

    public int generatedPlantId = 0;
    private int generatedHumidity = 0;

    public int setGeneratedPlantID(){
        Random random = new Random();

        int value = random.nextInt(3) + 1 ;
        generatedPlantId = value;
        return value;
    }

    public int setGeneratedHumidity(){
        Random random = new Random();

        int value = random.nextInt(100);
        generatedHumidity = value;
        return value;
    }

    public String run(){
        return "1" + ";" + setGeneratedHumidity() + ";" + "2" + ";" + setGeneratedHumidity() + ";" + "3" + ";" + setGeneratedHumidity();
    }

    public static void main(String[] args) throws InterruptedException {
        TLSClient tlsClient = new TLSClient();

        while(true) {
            sleep(5000);
            DataEmulator de = new DataEmulator();
            String generatedDataToSend = de.run();

            tlsClient.sendToBackend(generatedDataToSend);
        }
    }
}
