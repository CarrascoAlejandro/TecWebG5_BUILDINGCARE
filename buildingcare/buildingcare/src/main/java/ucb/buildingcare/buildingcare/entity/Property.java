package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "environments", nullable = false)
    private int environments;

    @Column(name = "dimensions", nullable = false, precision = 12, scale = 2)
    private BigDecimal dimensions;

    @Column(name = "value", nullable = false, precision = 12, scale = 2)
    private BigDecimal value;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "image", length = 250, nullable = false)
    private String image;

    @Column(name = "idSection", nullable = false)
    private int idSection;

    @Column(name = "idTypeProperty", nullable = false)
    private int idTypeProperty;

    @Column(name = "idUser", nullable = false)
    private int idUser;

    // Constructor por defecto
    public Property() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnvironments() {
        return environments;
    }

    public void setEnvironments(int environments) {
        this.environments = environments;
    }

    public BigDecimal getDimensions() {
        return dimensions;
    }

    public void setDimensions(BigDecimal dimensions) {
        this.dimensions = dimensions;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public int getIdTypeProperty() {
        return idTypeProperty;
    }

    public void setIdTypeProperty(int idTypeProperty) {
        this.idTypeProperty = idTypeProperty;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", environments=" + environments + ", dimensions=" + dimensions + ", value=" + value + ", description=" + description + ", image=" + image + ", idSection=" + idSection + ", idTypeProperty=" + idTypeProperty + ", idUser=" + idUser + "]";
    }
}
