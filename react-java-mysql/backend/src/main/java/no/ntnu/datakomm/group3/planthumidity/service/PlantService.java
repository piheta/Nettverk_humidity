package no.ntnu.datakomm.group3.planthumidity.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;

import no.ntnu.datakomm.group3.planthumidity.entity.Plant;
import no.ntnu.datakomm.group3.planthumidity.repository.PlantRepository;

@Service
public class PlantService{


    private PlantRepository plantRepository;

    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }

    //add plant
    public void addPlant(Plant plant){
        
    }
}