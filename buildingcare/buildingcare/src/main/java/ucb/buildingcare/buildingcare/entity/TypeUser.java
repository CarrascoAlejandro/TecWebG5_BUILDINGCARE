package ucb.buildingcare.buildingcare.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TypeUser")
public class TypeUser {

    public static final String ADMIN = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "permission", length = 30, nullable = false)
    private String permission;

    @OneToMany(mappedBy = "idTypeUser", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructor por defecto
    public TypeUser() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return permission;
    }
}

