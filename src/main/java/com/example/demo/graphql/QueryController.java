package com.example.demo.graphql;
import com.example.demo.entities.Household;
import com.example.demo.entities.HouseholdStatistics;
import com.example.demo.entities.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import services.HouseholdService;
import services.PetService;

import java.util.List;

@Controller
public class QueryController {

    private final HouseholdService householdService;
    private final PetService petService;

    @Autowired
    public QueryController(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    public List<Pet> getPetsByAnimalType(@Argument String animalType) {
        return petService.findByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(@Argument String eircode) {
        return householdService.getHousehold(eircode);
    }

    @QueryMapping
    public Pet getPet(@Argument Long id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    public HouseholdStatistics getStatistics() {
        return householdService.getHouseholdStatistics();
    }
}