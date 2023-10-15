package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;
import java.util.List;

import ucb.buildingcare.buildingcare.entity.Property;

public class PropertyResponse extends BuildingcareResponse {
    
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

    public PropertyResponse(String responseCode, List<Property> data){
        super(responseCode, data, "");
    }
}
