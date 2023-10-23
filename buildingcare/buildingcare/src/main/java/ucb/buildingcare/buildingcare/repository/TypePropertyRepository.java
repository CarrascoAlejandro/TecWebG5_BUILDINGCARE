package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.TypeProperty;

@Repository
public interface TypePropertyRepository extends JpaRepository<TypeProperty, Integer> {
    
}
