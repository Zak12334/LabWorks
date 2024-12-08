package com.example.demo.graphql;
import com.example.demo.entities.Household;
//import com.example.demo.services.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import services.HouseholdService;

@Controller
public class MutationController {

    private final HouseholdService householdService;

    @Autowired
    public MutationController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @MutationMapping
    public Household createHousehold(@Argument("household") Household household) {
        return householdService.createHousehold(household);
    }

    @MutationMapping
    public boolean deleteHousehold(@Argument String eircode) {
        return householdService.deleteHousehold(eircode);
    }

    @MutationMapping
    public boolean deletePet(@Argument Long id) {
        return householdService.deletePet(id);
    }
}