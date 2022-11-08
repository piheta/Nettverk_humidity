package no.ntnu.datakomm.group3.planthumidity.controllers;

import no.ntnu.datakomm.group3.planthumidity.entity.Greeting;
import no.ntnu.datakomm.group3.planthumidity.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private GreetingRepository repository;

    @GetMapping("/")
    public Greeting showHome(String name, Model model) {
        return repository.findById(1).orElse(new Greeting("Not Found 😕"));
    }

}
