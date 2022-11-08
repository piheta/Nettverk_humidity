package no.ntnu.datakomm.group3.planthumidity.repository;

import no.ntnu.datakomm.group3.planthumidity.entity.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Integer> {
}