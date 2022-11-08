package no.ntnu.datakomm.group3.planthumidity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import no.ntnu.datakomm.group3.planthumidity.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
