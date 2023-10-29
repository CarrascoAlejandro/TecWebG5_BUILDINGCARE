package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.buildingcare.buildingcare.entity.CommonArea;
import ucb.buildingcare.buildingcare.entity.Section;
import ucb.buildingcare.buildingcare.entity.TypeArea;

public interface CommonAreaRepository extends JpaRepository<CommonArea, Integer>{
    List<CommonArea> findAll();
    List<CommonArea> findByIdTypeArea(TypeArea typeAreaId);
    List<CommonArea> findByIdSection(Section idSection);
}
