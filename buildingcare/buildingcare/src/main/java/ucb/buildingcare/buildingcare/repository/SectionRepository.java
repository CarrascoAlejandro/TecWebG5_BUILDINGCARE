package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ucb.buildingcare.buildingcare.entity.Section;

public interface SectionRepository extends CrudRepository<Section, Integer> {
    @Query(value = "SELECT * FROM section WHERE idUser = ?1", nativeQuery = true)
    List<Section> findByIdUser(int idUser);
}
