package no.ntnu.Plants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import no.ntnu.Plants.entity.Humidity;
import no.ntnu.Plants.service.HumidityService;


@RestController
@RequestMapping(path = "/humidity")
public class HumidityController {
    @Autowired
    private HumidityService humidityService;
    
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{plantId}")
    public @ResponseBody Humidity getLastHumidity(@PathVariable("plantId") Integer plantId){

        return humidityService.getLastHumidity(plantId);
    }

}
