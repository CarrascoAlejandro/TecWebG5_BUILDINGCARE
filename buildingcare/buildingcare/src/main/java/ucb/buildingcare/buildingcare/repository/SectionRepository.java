package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ucb.buildingcare.buildingcare.entity.Section;
import ucb.buildingcare.buildingcare.entity.User;

public interface SectionRepository extends CrudRepository<Section, Integer> {
    List<Section> findByIdUser(User user);
    // List<Section> findByIdUser(int user);
}
