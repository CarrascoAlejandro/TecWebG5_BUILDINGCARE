package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.TypePost;

@Repository
public interface TypePostRepository extends JpaRepository<TypePost, Integer> {
    
}
