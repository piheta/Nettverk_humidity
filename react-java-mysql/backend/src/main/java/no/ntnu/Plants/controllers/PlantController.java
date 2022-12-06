package no.ntnu.Plants.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.ntnu.Plants.entity.Plant;
import no.ntnu.Plants.service.PlantService;

@RestController
@RequestMapping("/plants")
public class PlantController {
    

    @Autowired
    private PlantService plantservice;
    
    //get all plants
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants(){
        List<Plant> plants = plantservice.getAllPlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }
}