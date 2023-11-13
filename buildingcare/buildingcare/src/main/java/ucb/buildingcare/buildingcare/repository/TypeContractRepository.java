package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.buildingcare.buildingcare.entity.TypeContract;
import java.util.List;


public interface TypeContractRepository extends JpaRepository<TypeContract, Integer>{
    List<TypeContract> findByType(String type);
    List<TypeContract> findById(int id);
}
