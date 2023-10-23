package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;

public class PropertyRequest {
    
    private Integer propertyEnvironments;
    private BigDecimal propertyDimensions;
    private BigDecimal propertyValue;
    private String propertyDescription;
    private String propertyImage;
    private Integer propertyIdSection;
    private Integer propertyIdType;

    public PropertyRequest() {
    }
    public PropertyRequest(Integer propertyEnvironments, BigDecimal propertyDimensions, BigDecimal propertyValue,
            String propertyDescription, String propertyImage, Integer propertyIdSection, Integer propertyIdType) {
        this.propertyEnvironments = propertyEnvironments;
        this.propertyDimensions = propertyDimensions;
        this.propertyValue = propertyValue;
        this.propertyDescription = propertyDescription;
        this.propertyImage = propertyImage;
        this.propertyIdSection = propertyIdSection;
        this.propertyIdType = propertyIdType;
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

    public Integer getPropertyIdType() {
        return propertyIdType;
    }

    public void setPropertyIdType(Integer propertyIdType) {
        this.propertyIdType = propertyIdType;
    }
    
}
