package no.ntnu.Plants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import no.ntnu.Plants.humidityReciever.HumidityServer;

@SpringBootApplication
public class PlantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantsApplication.class, args);
		HumidityServer.run(5555);
	}
}