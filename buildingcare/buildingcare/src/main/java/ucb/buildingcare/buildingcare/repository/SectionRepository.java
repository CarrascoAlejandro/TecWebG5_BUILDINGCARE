package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import ucb.buildingcare.buildingcare.entity.Section;
import ucb.buildingcare.buildingcare.entity.User;

public interface SectionRepository {
    List<Section> findByIdUser(User user);
    List<Section> findByIdUser(int user);
}
