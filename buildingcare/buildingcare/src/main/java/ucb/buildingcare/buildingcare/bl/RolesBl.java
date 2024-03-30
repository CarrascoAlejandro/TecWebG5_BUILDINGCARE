package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.RoleAssignation;
import ucb.buildingcare.buildingcare.entity.Privilege.AccessPrivilege;
import ucb.buildingcare.buildingcare.entity.Privilege;
import ucb.buildingcare.buildingcare.entity.TypeUser;
import ucb.buildingcare.buildingcare.repository.PrivilegeRepository;
import ucb.buildingcare.buildingcare.repository.TypeUserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@Service
public class RolesBl {
    private static final Logger LOG = LoggerFactory.getLogger(RolesBl.class);

    @Autowired
    private final TypeUserRepository typeUserRepository;

    @Autowired
    private final PrivilegeRepository privilegeRepository;

    public RolesBl(TypeUserRepository typeUserRepository, PrivilegeRepository privilegeRepository) {
        this.typeUserRepository = typeUserRepository;
        this.privilegeRepository = privilegeRepository;
    }

    public String createTypeUser(RoleAssignation roleAssignation) throws BuildingcareException {
        LOG.info("Creating type user: " + roleAssignation.getName());
        TypeUser typeUser = new TypeUser();
        typeUser.setPermission(roleAssignation.getName());
        // Set privileges
        typeUser.setPrivileges(new ArrayList<>());
        for (Entry<String, String> entry : roleAssignation.getPrivileges().entrySet()) {
            LOG.info("Privilege: " + entry.getKey() + " Value: " + entry.getValue());
            AccessPrivilege accessPrivilege = AccessPrivilege.fromDisplayName(entry.getValue());
            Privilege privilege = privilegeRepository.findByModuleAccess(entry.getKey(), accessPrivilege.name());

            if(privilege == null) throw new BuildingcareException("El permiso no existe");

            LOG.info(privilege.toString());
            typeUser.getPrivileges().add(privilege);
        }

        typeUserRepository.save(typeUser);
        return "Role created: " + roleAssignation.getName();
    }

    public RoleAssignation assignPrivilegesToTypeUser(RoleAssignation roleAssignation) throws BuildingcareException {
        LOG.info("Assigning privileges to" + roleAssignation.getName());
        TypeUser typeUser;
        try {
            typeUser = typeUserRepository.findByPermission(roleAssignation.getName()).get(0);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new BuildingcareException("Rol no existe");
        }


        for (Entry<String, String> entry : roleAssignation.getPrivileges().entrySet()) {
            LOG.info("Privilege: " + entry.getKey() + " Value: " + entry.getValue());
            AccessPrivilege accessPrivilege = AccessPrivilege.fromDisplayName(entry.getValue());
            Privilege privilege = privilegeRepository.findByModuleAccess(entry.getKey(), accessPrivilege.name());
            
            if (privilege == null) throw new BuildingcareException("Privilege not found");
            
            typeUser.getPrivileges().add(privilege);
        }
        typeUserRepository.save(typeUser);

        return roleAssignation;
    }

    public List<RoleAssignation> listRoles() {
        List<TypeUser> typeUsers = typeUserRepository.findAll();
        List<RoleAssignation> roles = new ArrayList<>();
        typeUsers.forEach(typeUser -> {
            roles.add(new RoleAssignation(typeUser));
        });
        return roles;
    }

    public void deleteTypeUser(String roleName) throws BuildingcareException{
        LOG.info("Deleting type user: " + roleName);
        TypeUser typeUser = typeUserRepository.findByPermission(roleName).get(0);
        if (typeUser.getId() == 1 || typeUser.getId() == 4) throw new BuildingcareException("El rol " + roleName + " es un rol por defecto y no puede ser eliminado");
        typeUserRepository.delete(typeUser);
    }
}
