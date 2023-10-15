package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;

public class PropertyRequest {
    
    private Integer propertyEnvironments;
    private BigDecimal propertyDimensions;
    private BigDecimal propertyValue;
    private String propertyDescription;
    private String propertyImage;

    public PropertyRequest() {
    }
    public PropertyRequest(Integer propertyEnvironments, BigDecimal propertyDimensions, BigDecimal propertyValue,
            String propertyDescription, String propertyImage) {
        this.propertyEnvironments = propertyEnvironments;
        this.propertyDimensions = propertyDimensions;
        this.propertyValue = propertyValue;
        this.propertyDescription = propertyDescription;
        this.propertyImage = propertyImage;
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

    
}
