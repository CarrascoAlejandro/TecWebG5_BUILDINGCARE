package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;

public class PropertyDto {
    private int id;
    private int environments;
    private BigDecimal dimensions;
    private BigDecimal value;
    private String description;
    private String image;
    private int idSection;
    private int idTypeProperty;
    private int idUser;

    public PropertyDto() {
    }

    public PropertyDto(int id, int environments, BigDecimal dimensions, BigDecimal value, String description, String image, int idSection, int idTypeProperty, int idUser) {
        this.id = id;
        this.environments = environments;
        this.dimensions = dimensions;
        this.value = value;
        this.description = description;
        this.image = image;
        this.idSection = idSection;
        this.idTypeProperty = idTypeProperty;
        this.idUser = idUser;
    }

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
}
