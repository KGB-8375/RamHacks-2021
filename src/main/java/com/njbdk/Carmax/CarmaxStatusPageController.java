package com.njbdk.Carmax;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarmaxStatusPageController {
    Carmax[] cars = CarmaxStatusPageApplication.cars;

    @ResponseBody
    @GetMapping("/cars")
    public String[] allCars() {
        return getVins();
    }

    @ResponseBody
    @GetMapping("/parts")
    public CarPart[] allParts(@RequestParam(value = "vin") String vin){
        Carmax car = lookupVin(vin);

        if(car != null) {
            return car.carParts_a();
        }

        return null;
    }

    @ResponseBody
    @GetMapping("/search")
    public CarPart search(@RequestParam(value = "name") String name, @RequestParam(value = "vin") String vin) {
        Carmax car = lookupVin(vin);

        if(car != null) {
            return car.getPart(name);
        }

        return null;
    }

    @ResponseBody
    @GetMapping("/broken")
    public CarPart[] broken(@RequestParam(value = "vin") String vin) {
        Carmax car = lookupVin(vin);

        if(car != null) {
            return car.brokenParts_a();
        }

        return null;
    }

    @ResponseBody
    @GetMapping("/repairs")
    public CarPart[] repairs(@RequestParam(value = "vin") String vin) {
        Carmax car = lookupVin(vin);

        if(car != null) {
            return car.repairsInProgress();
        }

        return null;
    }

    @RequestMapping(value = "/status")
    public String status(@RequestParam(value = "vin", defaultValue = "Blank") String vin, Model model) {
        Carmax car = lookupVin(vin);
        model.addAttribute("vinNumber", vin);

        if(car != null) {
            model.addAttribute("repairStatus", String.format("%.0f%%", car.carProgress() * 100));
            model.addAttribute("partsInRepair", car.repairsInProgress());
            model.addAttribute("partsNeedRepair", car.repairsNotInProgress());
            model.addAttribute("repairCost", car.totalRepairCost());
            model.addAttribute("completeDate", car.completeDate());
            model.addAttribute("car", car);
            return "status";
        }

        return "error";
	}

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("cars", cars);
        return "index";
    }

    private Carmax lookupVin(String vin) {
        for(int i = 0; i < cars.length; i++) {
            if(cars[i].getVin().equals(vin)) {
                return cars[i];
            }
        }
        return null;
    }

    private String[] getVins() {
        String[] vins = new String[cars.length];
        for(int i = 0; i < cars.length; i++) {
            vins[i] = cars[i].getVin();
        }
        return vins;
    }
}
