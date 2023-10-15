package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import ucb.buildingcare.buildingcare.dto.PropertyResponse;
import ucb.buildingcare.buildingcare.entity.Property;

public class PropertyBl {

    private PropertyRepository propertyRepository;
    private UserRepository userRepository;
    private SectionRepository sectionRepository;

    public List<PropertyResponse> ListAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        for (Property property : properties) {
            PropertyResponse propertyResponse = new PropertyResponse();
            propertyResponse.setPropertyId(property.getPropertyId());
            propertyResponse.setPropertyName(property.getPropertyName());
            propertyResponse.setPropertyAddress(property.getPropertyAddress());
            propertyResponse.setPropertyPhone(property.getPropertyPhone());
            propertyResponse.setPropertyEmail(property.getPropertyEmail());
            propertyResponse.setPropertyType(property.getPropertyType());
            propertyResponse.setPropertyStatus(property.getPropertyStatus());
            propertyResponse.setPropertyDate(property.getPropertyDate());
            propertyResponse.setPropertyDescription(property.getPropertyDescription());
            propertyResponse.setUserId(property.getUserId());
            propertyResponse.setSectionId(property.getSectionId());
            propertyResponses.add(propertyResponse);
        }
        return propertyResponses;
    }

    public PropertyResponse getPropertyById(Integer id) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(property.getPropertyId());
        propertyResponse.setPropertyName(property.getPropertyName());
        propertyResponse.setPropertyAddress(property.getPropertyAddress());
        propertyResponse.setPropertyPhone(property.getPropertyPhone());
        propertyResponse.setPropertyEmail(property.getPropertyEmail());
        propertyResponse.setPropertyType(property.getPropertyType());
        propertyResponse.setPropertyStatus(property.getPropertyStatus());
        propertyResponse.setPropertyDate(property.getPropertyDate());
        propertyResponse.setPropertyDescription(property.getPropertyDescription());
        propertyResponse.setUserId(property.getUserId());
        propertyResponse.setSectionId(property.getSectionId());
        return propertyResponse;
    }

    public PropertyResponse createProperty(PropertyRequest propertyRequest) {
        Property property = new Property();
        property.setPropertyName(propertyRequest.getPropertyName());
        property.setPropertyAddress(propertyRequest.getPropertyAddress());
        property.setPropertyPhone(propertyRequest.getPropertyPhone());
        property.setPropertyEmail(propertyRequest.getPropertyEmail());
        property.setPropertyType(propertyRequest.getPropertyType());
        property.setPropertyStatus(propertyRequest.getPropertyStatus());
        property.setPropertyDate(propertyRequest.getPropertyDate());
        property.setPropertyDescription(propertyRequest.getPropertyDescription());
        property.setUserId(propertyRequest.getUserId());
        property.setSectionId(propertyRequest.getSectionId());
        propertyRepository.save(property);
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(property.getPropertyId());
        propertyResponse.setPropertyName(property.getPropertyName());
        propertyResponse.setPropertyAddress(property.getPropertyAddress());
        propertyResponse.setPropertyPhone(property.getPropertyPhone());
        propertyResponse.setPropertyEmail(property.getPropertyEmail());
        propertyResponse.setPropertyType(property.getPropertyType());
        propertyResponse.setPropertyStatus(property.getPropertyStatus());
        propertyResponse.setPropertyDate(property.getPropertyDate());
        propertyResponse.setPropertyDescription(property.getPropertyDescription());
        propertyResponse.setUserId(property.getUserId());
        propertyResponse.setSectionId(property.getSectionId());
        return propertyResponse;
    }

    public PropertyResponse updateProperty(Integer id, PropertyRequest propertyRequest) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        property.setPropertyName(propertyRequest.getPropertyName());
        property.setPropertyAddress(propertyRequest.getPropertyAddress());
        property.setPropertyPhone(propertyRequest.getPropertyPhone());
        property.setPropertyEmail(propertyRequest.getPropertyEmail());
        property.setPropertyType(propertyRequest.getPropertyType());
        property.setPropertyStatus(propertyRequest.getPropertyStatus());
        property.setPropertyDate(propertyRequest.getPropertyDate());
        property.setPropertyDescription(propertyRequest.getPropertyDescription());
        property.setUserId(propertyRequest.getUserId());
        property.setSectionId(propertyRequest.getSectionId());
        propertyRepository.save(property);
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(property.getPropertyId());
        propertyResponse.setPropertyName(property.getPropertyName());
        propertyResponse.setPropertyAddress(property.getPropertyAddress());
        propertyResponse.setPropertyPhone(property.getPropertyPhone());
        propertyResponse.setPropertyEmail(property.getPropertyEmail());
        propertyResponse.setPropertyType(property.getPropertyType());
        propertyResponse.setPropertyStatus(property.getPropertyStatus());
        propertyResponse.setPropertyDate(property.getPropertyDate());
        propertyResponse.setPropertyDescription(property.getPropertyDescription());
        propertyResponse.setUserId(property.getUserId());
        propertyResponse.setSectionId(property.getSectionId());
        return propertyResponse;
    }

    public PropertyResponse deleteProperty(Integer id) {
        Property property = propertyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        propertyRepository.delete(property);
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(property.getPropertyId());
        propertyResponse.setPropertyName(property.getPropertyName());
        propertyResponse.setPropertyAddress(property.getPropertyAddress());
        propertyResponse.setPropertyPhone(property.getPropertyPhone());
        propertyResponse.setPropertyEmail(property.getPropertyEmail());
        propertyResponse.setPropertyType(property.getPropertyType());
        propertyResponse.setPropertyStatus(property.getPropertyStatus());
        propertyResponse.setPropertyDate(property.getPropertyDate());
        propertyResponse.setPropertyDescription(property.getPropertyDescription());
        propertyResponse.setUserId(property.getUserId());
        propertyResponse.setSectionId(property.getSectionId());
        return propertyResponse;
    }
    
}
