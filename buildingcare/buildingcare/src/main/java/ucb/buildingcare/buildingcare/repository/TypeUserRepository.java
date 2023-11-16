package ucb.buildingcare.buildingcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.TypeUser;
import java.util.List;


@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Integer> {
    public List<TypeUser> findByPermission(String permission);
}
