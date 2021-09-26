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
    @GetMapping("/parts")
    public CarPart[] allParts(){
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

    @ResponseBody
    @GetMapping("/repairs")
    public CarPart[] repairs() {
        return carmax.repairsInProgress();
    }

    @RequestMapping(value = "/")
    public String status(Model model) {
        model.addAttribute("repairStatus", String.format("%.0f%%", carmax.carProgress() * 100));
        model.addAttribute("partsInRepair", carmax.repairsInProgress());
        model.addAttribute("partsNeedRepair", carmax.repairsNotInProgress());
        model.addAttribute("repairCost", carmax.totalRepairCost());
        model.addAttribute("completeDate", carmax.completeDate());
		return "index";
	}
}
