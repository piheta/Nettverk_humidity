package no.ntnu.Plants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import no.ntnu.Plants.entity.Humidity;

public interface HumidityRepository extends JpaRepository<Humidity, Integer> {
    
}
