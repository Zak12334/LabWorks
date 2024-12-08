package services;

import com.example.demo.entities.Pet;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(Long id);
    Pet createPet(Pet pet);
    void deletePet(Long id);
    Pet updatePetName(Long id, String name);
    List<Pet> findByAnimalType(String animalType);

}

