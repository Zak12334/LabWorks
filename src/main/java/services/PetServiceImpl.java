package services;
import com.example.demo.entities.Pet;
import repositories.PetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Pet updatePetName(Long id, String name) {
        Pet pet = getPetById(id);
        pet.setName(name);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }
}
