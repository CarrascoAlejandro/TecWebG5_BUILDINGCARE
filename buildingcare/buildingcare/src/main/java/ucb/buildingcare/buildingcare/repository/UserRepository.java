package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.TypeUser;
import ucb.buildingcare.buildingcare.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsenameAndPassword(String usename, String password);//Nota: Se puso en la base "usename" en vez de "username"

    @Query(value = "SELECT * FROM user WHERE idTypeUser = ?", nativeQuery = true)
    List<User> findByIdTypeUser(int typeUser);

    List<User> findByIdTypeUser(TypeUser typeUser);
    
}
