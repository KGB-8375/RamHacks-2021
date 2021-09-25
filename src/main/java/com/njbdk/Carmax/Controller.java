package com.njbdk.Carmax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Carmax carmax = CarmaxStatusPageApplication.carmax;

    @GetMapping("/")
    public CarPart[] working(){
        return carmax.carParts_a();
    }
    
    @GetMapping("/search")
    public CarPart search(@RequestParam(value = "name") String name) {
        return carmax.getPart(name);
    }

    @GetMapping("/broken")
    public String[] broken() {
        return carmax.brokenParts_a();
    }
}
