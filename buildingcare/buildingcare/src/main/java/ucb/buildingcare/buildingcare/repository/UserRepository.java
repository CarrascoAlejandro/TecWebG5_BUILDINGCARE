package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ucb.buildingcare.buildingcare.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsename(String usename);//Nota: Se puso en la base "usename" en vez de "username"

    @Query(value = "SELECT * FROM user WHERE idTypeUser = ?1", nativeQuery = true)
    List<User> findByIdTypeUser(int typeUser);
    
}
