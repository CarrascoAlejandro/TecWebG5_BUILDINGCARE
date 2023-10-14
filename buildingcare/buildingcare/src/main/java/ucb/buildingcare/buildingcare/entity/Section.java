package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "location", length = 100, nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private User idUser;

    // Constructor por defecto
    public Section() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Section [id=" + id + ", name=" + name + ", location=" + location + ", idUser=" + idUser + "]";
    }
}
