package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
