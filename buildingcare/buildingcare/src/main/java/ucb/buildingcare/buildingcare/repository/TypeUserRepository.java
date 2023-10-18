package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.TypeUser;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
    
}
