package no.ntnu.Plants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import no.ntnu.Plants.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
