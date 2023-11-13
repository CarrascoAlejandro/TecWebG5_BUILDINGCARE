package ucb.buildingcare.buildingcare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.buildingcare.buildingcare.entity.Post;
import ucb.buildingcare.buildingcare.entity.TypePost;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM post ORDER BY date DESC ", nativeQuery = true)
    List<Post> findAll();

    List<Post> findByIdTypePost(TypePost idTypePost);
}
