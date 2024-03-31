package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.RolesBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.RoleAssignation;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesAPI {
    
    private static final Logger LOG = LoggerFactory.getLogger(RolesAPI.class);

    @Autowired
    private final RolesBl rolesBl;

    public RolesAPI(RolesBl rolesBl) {
        this.rolesBl = rolesBl;
    }

    @GetMapping(path = "/list")
    public BuildingcareResponse listRoles() {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setResponseCode("ROLE-0000");
            buildingcareResponse.setData(rolesBl.listRoles());
        } catch (Exception e) {
            buildingcareResponse.setResponseCode("ROLE-6000");
            LOG.error(e.getMessage());
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @PostMapping(path = "/create")
    public BuildingcareResponse createRole(@RequestBody RoleAssignation roleAssignation) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(rolesBl.createTypeUser(roleAssignation));
            LOG.info("Role created");
            buildingcareResponse.setResponseCode("ROLE-0001");
        } catch (Exception e) {
            buildingcareResponse.setResponseCode("ROLE-6001");
            LOG.error(e.getMessage());
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/assign")
    public BuildingcareResponse assignPrivileges(@RequestBody RoleAssignation roleAssignation) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(rolesBl.assignPrivilegesToTypeUser(roleAssignation));
            LOG.info("Privileges assigned");
            buildingcareResponse.setResponseCode("ROLE-0002");
        } catch (BuildingcareException e) {
            buildingcareResponse.setResponseCode("ROLE-6002");
            LOG.error(e.getMessage());
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @DeleteMapping
    public BuildingcareResponse deleteRole(@RequestParam String roleName) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            rolesBl.deleteTypeUser(roleName);
            buildingcareResponse.setData("Role Deleted");
            LOG.info("Role deleted");
            buildingcareResponse.setResponseCode("ROLE-0003");
        } catch (BuildingcareException e) {
            buildingcareResponse.setResponseCode("ROLE-6003");
            LOG.error(e.getMessage());
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }
}
