package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PropertyResponse;
import ucb.buildingcare.buildingcare.entity.Property;

public class PropertyBl {

    private PropertyRepository propertyRepository;
    private UserRepository userRepository;
    private SectionRepository sectionRepository;


    public BuildingcareResponse ListAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        for (Property property : properties) {
            propertyResponses.add(new PropertyResponse(property));
        }
        return new BuildingcareResponse(propertyResponses);
    }

    public PropertyResponse getPropertyById(Integer id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            return new PropertyResponse(property);
        } else {
            //TODO raise exception
            return null;
        }
    }

    public PropertyResponse createProperty(PropertyRequest propertyRequest) {
        Property property = new Property();
        property.setEnvironments(propertyRequest.getPropertyEnvironments());
        property.setDimensions(propertyRequest.getPropertyDimensions());
        property.setValue(propertyRequest.getPropertyValue());
        property.setDescription(propertyRequest.getPropertyDescription());
        property.setImage(propertyRequest.getPropertyImage());
        property.setIdSection(sectionRepository.findById(propertyRequest.getPropertyIdSection()).orElse(null));
        property.setIdUser(userRepository.findById(propertyRequest.getPropertyIdUser()).orElse(null));
        propertyRepository.save(property);
        return new PropertyResponse(property);
    }

    public PropertyResponse updateProperty(Integer id, PropertyRequest propertyRequest) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setEnvironments(propertyRequest.getPropertyEnvironments());
            property.setDimensions(propertyRequest.getPropertyDimensions());
            property.setValue(propertyRequest.getPropertyValue());
            property.setDescription(propertyRequest.getPropertyDescription());
            property.setImage(propertyRequest.getPropertyImage());
            property.setIdSection(sectionRepository.findById(propertyRequest.getPropertyIdSection()).orElse(null));
            property.setIdUser(userRepository.findById(propertyRequest.getPropertyIdUser()).orElse(null));
            propertyRepository.save(property);
            return new PropertyResponse(property);
        } else {
            //TODO raise exception
            return null;
        }
    }

    public void deleteProperty(Integer id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            propertyRepository.delete(property);
        } else {
            //TODO raise exception
        }
    }

}