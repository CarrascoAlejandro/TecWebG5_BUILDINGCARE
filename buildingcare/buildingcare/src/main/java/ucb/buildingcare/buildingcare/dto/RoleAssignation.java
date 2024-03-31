package ucb.buildingcare.buildingcare.dto;

import java.util.HashMap;
import java.util.Map;

import ucb.buildingcare.buildingcare.entity.TypeUser;

public class RoleAssignation {
    private String name;
    private Map<String, String> privileges;
    
    public RoleAssignation(String name, Map<String, String> privileges) {
        this.name = name;
        this.privileges = privileges;
    }
    public RoleAssignation() {
    }
    public RoleAssignation(TypeUser typeUser) {
        this.name = typeUser.getPermission();
        
        // Set privileges
        this.privileges = new HashMap<>();
        typeUser.getPrivileges().forEach(privilege -> {
            this.privileges.put(privilege.getModule(), privilege.getAccessPrivilege().getDisplayName());
        });
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<String, String> getPrivileges() {
        return privileges;
    }
    public void setPrivileges(Map<String, String> privileges) {
        this.privileges = privileges;
    }
    
}
