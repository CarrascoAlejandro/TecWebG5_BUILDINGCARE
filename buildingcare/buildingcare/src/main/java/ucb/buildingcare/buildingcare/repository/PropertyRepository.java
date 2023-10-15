package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.buildingcare.buildingcare.entity.Property;
import ucb.buildingcare.buildingcare.entity.TypeProperty;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findAll();
    Property findById(int id);

    @Query("SELECT p.id FROM Property p")
    List<Integer> findAllPropertyIds();

    List<Property> findByIdTypeProperty(TypeProperty idTypeProperty);
    List<Property> findByIdTypeProperty(int idTypeProperty);

    //save en servies
}
