package no.ntnu.datakomm.group3.planthumidity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.ntnu.datakomm.group3.planthumidity.entity.Plant;
import no.ntnu.datakomm.group3.planthumidity.service.PlantService;

@Controller
@RequestMapping("/plants")
public class PlantController {
    

    @Autowired
    private PlantService plantservice;
    
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        return new ResponseEntity<>(plantservice.getAllPlants(), HttpStatus.OK);
    }

    
    
}