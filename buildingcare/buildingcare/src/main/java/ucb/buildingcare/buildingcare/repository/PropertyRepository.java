package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.buildingcare.buildingcare.entity.Property;
import ucb.buildingcare.buildingcare.entity.Section;
import ucb.buildingcare.buildingcare.entity.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    Property findById(int id);

    @Query("SELECT p.id FROM Property p")
    List<Integer> findAllPropertyIds();

    /*

    //FIXME Fabi esto no esta funcionando como debe y son muchos errores para corregir ahora

    List<Property> findByIdTypeProperty(int idTypeProperty);

    List<Property> findByEnvironments(int environments);

    List<Property> findByDimensions(double dimensions);
    List<Property> findByDimensionsBetween(double dimensions1, double dimensions2); 

    List<Property> findByValue(BigDecimal value);
    List<Property> findByValue(double value);

    List<Property> findByIdUser(User idUser);
    List<Property> findByIdUser(int idUser);

    List<Property> findByIdSection(Section idSection);
    List<Property> findByIdSection(int idSection);

    List<Property> findByIdUserAndIdSection(int idUser, int idSection);

    */
}
