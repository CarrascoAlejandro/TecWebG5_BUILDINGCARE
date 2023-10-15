package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import ucb.buildingcare.buildingcare.entity.TypeUser;
import ucb.buildingcare.buildingcare.entity.User;

public interface UserRepository {
    List<User> findByUsename(String usename);//Nota: Se puso en la base "usename" en vez de "username"
    List<User> findByIdTypeUser(TypeUser typeUser);
    List<User> findByIdTypeUser(int typeUser);
    
}
