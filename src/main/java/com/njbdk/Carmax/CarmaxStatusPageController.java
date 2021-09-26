package com.njbdk.Carmax;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarmaxStatusPageController {
    Carmax carmax = CarmaxStatusPageApplication.carmax;

    @ResponseBody
    @GetMapping("/")
    public CarPart[] working(){
        return carmax.carParts_a();
    }

    @ResponseBody
    @GetMapping("/search")
    public CarPart search(@RequestParam(value = "name") String name) {
        return carmax.getPart(name);
    }

    @ResponseBody
    @GetMapping("/broken")
    public CarPart[] broken() {
        return carmax.brokenParts_a();
    }

    @RequestMapping(value = "/status")
    public String status(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "status";
	}
}
