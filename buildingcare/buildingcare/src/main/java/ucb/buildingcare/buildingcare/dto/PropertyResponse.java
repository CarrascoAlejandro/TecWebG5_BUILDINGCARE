package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;

import ucb.buildingcare.buildingcare.entity.Property;

public class PropertyResponse{
    //Esta clase es la que se encarga de enviar la respuesta sobre property al front end
    
    private Integer id;
    private Integer propertyEnvironments;
    private BigDecimal propertyDimensions;
    private BigDecimal propertyValue;
    private String propertyDescription;
    private String propertyImage;
    private Integer propertyIdSection;
    private String propertyType;
    private String propertyOwner;

    public PropertyResponse() {
    }

    public PropertyResponse(Property property){
        this.id = property.getId();
        this.propertyEnvironments = property.getEnvironments();
        this.propertyDimensions = property.getDimensions();
        this.propertyValue = property.getValue();
        this.propertyDescription = property.getDescription();
        this.propertyImage = property.getImage();
        this.propertyIdSection = property.getIdSection().getId();
        // this.propertyType = property.getIdSection().getName();
        this.propertyType = property.getIdTypeProperty().getType();
        this.propertyOwner = property.getIdUser().getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idProperty) {
        this.id = idProperty;
    }

    public Integer getPropertyEnvironments() {
        return propertyEnvironments;
    }

    public void setPropertyEnvironments(Integer propertyEnvironments) {
        this.propertyEnvironments = propertyEnvironments;
    }

    public BigDecimal getPropertyDimensions() {
        return propertyDimensions;
    }

    public void setPropertyDimensions(BigDecimal propertyDimensions) {
        this.propertyDimensions = propertyDimensions;
    }

    public BigDecimal getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(BigDecimal propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
    }

    public Integer getPropertyIdSection() {
        return propertyIdSection;
    }

    public void setPropertyIdSection(Integer propertyIdSection) {
        this.propertyIdSection = propertyIdSection;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    
}
