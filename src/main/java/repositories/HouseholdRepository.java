package repositories;
import com.example.demo.entities.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, String> {
    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Optional<Household> findByEircodeWithPets(String eircode);

    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    List<Household> findHouseholdsWithNoPets();

    long countByNumberOfOccupants(int numberOfOccupants);

    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOfOccupants = h.maxNumberOfOccupants")
    long countByNumberOfOccupantsEqualsMaxNumberOfOccupants();




}