package no.ntnu.datakomm.group3.planthumidity;

import no.ntnu.datakomm.group3.planthumidity.humidityReciever.HumidityServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"no.ntnu.datakomm.group3.planthumidity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        HumidityServer.run();
    }
}
