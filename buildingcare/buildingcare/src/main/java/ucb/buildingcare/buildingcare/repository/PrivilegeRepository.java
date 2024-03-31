package ucb.buildingcare.buildingcare.repository;

import org.springframework.stereotype.Repository;

import ucb.buildingcare.buildingcare.entity.Privilege;
import ucb.buildingcare.buildingcare.entity.Privilege.AccessPrivilege;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{

    @Query(value = "SELECT * FROM privilege WHERE module = ?1 AND access_privilege = ?2 LIMIT 1", nativeQuery = true)
    Privilege findByModuleAccess(String module, String accessPrivilege);
}
