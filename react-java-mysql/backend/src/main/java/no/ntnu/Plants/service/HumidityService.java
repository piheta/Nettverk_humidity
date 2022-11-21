package no.ntnu.Plants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no.ntnu.Plants.entity.Humidity;
import no.ntnu.Plants.entity.Plant;
import no.ntnu.Plants.repository.HumidityRepository;
import no.ntnu.Plants.repository.PlantRepository;

@Service
public class HumidityService {
    
    @Autowired
	private HumidityRepository humidityRepository;

    @Autowired
    private PlantRepository plantRepository;

    public void addHumidity(int plantId, int humidity){
        Plant plant = plantRepository.findById(plantId).orElse(null);

        if( plant != null){
            Humidity h = new Humidity(plantRepository.findById(plantId).orElseThrow(),humidity);
        humidityRepository.save(h);
        } else {
            System.out.println("Plant doesnt exist");
        }
    }

    public Humidity getLastHumidity(Integer plantId){
        return humidityRepository.findFirstByOrderByHumidityId().orElseThrow();
    }
}
