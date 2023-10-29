package ucb.buildingcare.buildingcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.buildingcare.buildingcare.entity.Contract;
import ucb.buildingcare.buildingcare.entity.Property;
import ucb.buildingcare.buildingcare.entity.TypeContract;
import ucb.buildingcare.buildingcare.entity.User;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAll();
    List<Contract> findByIdProperty(Property idProperty);
    List<Contract> findByIdUser(User idUser);
    List<Contract> findByIdTypeContract(TypeContract idTypeContract);

}