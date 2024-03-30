package ucb.buildingcare.buildingcare.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_privilege", length = 30, nullable = false)
    private AccessPrivilege accessPrivilege;

    @Column(name = "module", length = 30, nullable = false)
    private String module;

    @ManyToMany
    @JoinColumn(name = "idTypeUser", referencedColumnName = "id", nullable = false)
    private List<TypeUser> idTypeUser;
    

    public Privilege() {
    }

    public Privilege(int id, AccessPrivilege accessPrivilege, String module, List<TypeUser> idTypeUser) {
        this.id = id;
        this.accessPrivilege = accessPrivilege;
        this.module = module;
        this.idTypeUser = idTypeUser;
    }


    public enum AccessPrivilege {
        None("Ninguno"), 
        Read("Lectura"), 
        Write("Modificacion");

        private final String displayName;

        AccessPrivilege(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static AccessPrivilege fromDisplayName(String name){
            for (AccessPrivilege privilege : AccessPrivilege.values()) {
                if (privilege.getDisplayName().equals(name)) {
                    return privilege;
                }
            }
            throw new IllegalArgumentException("Invalid AccessPrivilege display name: " + name);
        }
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public AccessPrivilege getAccessPrivilege() {
        return accessPrivilege;
    }


    public void setAccessPrivilege(AccessPrivilege accessPrivilege) {
        this.accessPrivilege = accessPrivilege;
    }


    public String getModule() {
        return module;
    }


    public void setModule(String module) {
        this.module = module;
    }


    public List<TypeUser> getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(List<TypeUser> idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    @Override
    public String toString(){
        return "Privilege{" +
                "id=" + id +
                ", accessPrivilege=" + accessPrivilege +
                ", module='" + module + '\'' +
                '}';
    }
}
