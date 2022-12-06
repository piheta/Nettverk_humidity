package no.ntnu.Plants.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import no.ntnu.Plants.entity.Plant;


public interface PlantRepository extends JpaRepository<Plant, Integer> {
    
}
