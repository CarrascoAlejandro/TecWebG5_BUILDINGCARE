package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUser;

    @Column(name = "name", length = 128, nullable = true)
    private String name;

    @Column(name = "usename", length = 128, nullable = false)
    private String usename;

    @Column(name = "password", length = 32, nullable = false)
    private String password;

    @Column(name = "email", length = 128, nullable = true)
    private String email;

    @Column(name = "CI", length = 15, nullable = true)
    private String CI;

    @Column(name = "phone", length = 13, nullable = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "idTypeUser", referencedColumnName = "id", nullable = false)
    private TypeUser idTypeUser;

    // Constructor por defecto
    public User() {
    }

    // Getters y Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeUser getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(TypeUser idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    @Override
    public String toString() {
        return "\"User\" [idUser=" + idUser + ", name=" + name + ", usename=" + usename + ", password=" + password + ", email=" + email + ", CI=" + CI + ", phone=" + phone + ", idTypeUser=" + idTypeUser + "]";
    }
}
