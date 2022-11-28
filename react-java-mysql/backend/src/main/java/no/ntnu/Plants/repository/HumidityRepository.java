package no.ntnu.Plants.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import no.ntnu.Plants.entity.Humidity;

public interface HumidityRepository extends JpaRepository<Humidity, Integer> {
    //@Query(value = "SELECT h FROM Humidity ORDER BY humidityId ")
    Optional<Humidity> findFirstByPlantPlantIdOrderByHumidityIdDesc(Integer plantId);

    //Optional<Humidity> findLastHumidity(Integer plantId);
}
