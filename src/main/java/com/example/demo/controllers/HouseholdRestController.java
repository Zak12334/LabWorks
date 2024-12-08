package com.example.demo.controllers;

import com.example.demo.entities.Household;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.HouseholdService;
import java.util.List;

@RestController
@RequestMapping("/households")
public class HouseholdRestController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("/no-pets")
    public List<Household> getHouseholdsWithNoPets() {
        return householdService.getHouseholdsWithNoPets();
    }

    @GetMapping("/{eircode}")
    public Household getHousehold(@PathVariable String eircode) {
        Household household = householdService.getHousehold(eircode);
        if (household == null) {
            throw new RuntimeException("Household not found");
        }
        return household;
    }
    @DeleteMapping("/{eircode}")
    public void deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
    }

    @PostMapping
    public Household createHousehold(@RequestBody Household household) {
        return householdService.createHousehold(household);
    }
}