package no.ntnu.Plants;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import no.ntnu.Plants.humidityReciever.HumidityServer;

@SpringBootApplication
public class PlantsApplication {

	@Autowired
	HumidityServer tlsServer;

	public static void main(String[] args) {
		SpringApplication.run(PlantsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		tlsServer.start();
	}
}