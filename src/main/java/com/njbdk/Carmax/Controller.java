package com.njbdk.Carmax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Carmax carmax = new Carmax();

    @GetMapping("/")
    public String index() {
        return String.format("Car is %.0f%% complete!\n", carmax.carProgress() * 100.0);
    }
}
