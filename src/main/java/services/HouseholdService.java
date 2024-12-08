package services;

import com.example.demo.entities.Household;
//import com.example.demo.entities.HouseholdStatistics;
import com.example.demo.entities.HouseholdStatistics;
import com.example.demo.entities.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.HouseholdRepository;
import repositories.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HouseholdService {
    @Autowired
    private HouseholdRepository householdRepository;

    @Autowired
    private PetRepository petRepository;

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public List<Household> getHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    public Household getHousehold(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode).orElse(null);
    }

    public boolean deleteHousehold(String eircode) {
        Optional<Household> household = householdRepository.findById(eircode);
        if (household.isPresent()) {
            householdRepository.delete(household.get());
            return true;
        }
        return false;
    }

    public boolean deletePet(Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            petRepository.delete(pet.get());
            return true;
        }
        return false;
    }

    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    public HouseholdStatistics getHouseholdStatistics() {
        HouseholdStatistics statistics = new HouseholdStatistics();
        statistics.setEmptyHouses((int) householdRepository.countByNumberOfOccupants(0));
        statistics.setFullHouses((int) householdRepository.countByNumberOfOccupantsEqualsMaxNumberOfOccupants());
        return statistics;
    }
}