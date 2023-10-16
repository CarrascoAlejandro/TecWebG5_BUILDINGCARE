package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PropertyRequest;
import ucb.buildingcare.buildingcare.dto.PropertyResponse;
import ucb.buildingcare.buildingcare.entity.Property;
import ucb.buildingcare.buildingcare.repository.PropertyRepository;
import ucb.buildingcare.buildingcare.repository.SectionRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;

@Service
public class PropertyBl {

    Logger LOGGER = LoggerFactory.getLogger(PropertyBl.class);

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public PropertyBl(PropertyRepository propertyRepository, UserRepository userRepository, SectionRepository sectionRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
        this.sectionRepository = sectionRepository;
    }
    public BuildingcareResponse ListAllProperties() {
        LOGGER.info("PropertyBl - ListAllProperties");
        List<Property> properties = propertyRepository.findAll();
        LOGGER.info("el tamano de properties List<Property> es: "+ properties.size());
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        for (Property property : properties) {
            LOGGER.info("en el for de List<Property> properties: "+ property.toString());
            propertyResponses.add(new PropertyResponse(property));
        }
        LOGGER.info("retornando new BuildingcareResponse(propertyResponses): "+ new BuildingcareResponse(propertyResponses).toString());
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

    public PropertyResponse createProperty(PropertyRequest propertyRequest, Integer token) {
        Property property = new Property();
        LOGGER.info("Entrando a crear propiedad BL");
        property.setEnvironments(propertyRequest.getPropertyEnvironments());
        property.setDimensions(propertyRequest.getPropertyDimensions());
        property.setValue(propertyRequest.getPropertyValue());
        property.setDescription(propertyRequest.getPropertyDescription());
        property.setImage(propertyRequest.getPropertyImage());
        property.setIdSection(sectionRepository.findById(propertyRequest.getPropertyIdSection()).orElse(null));
        property.setIdUser(userRepository.findById(token).get());
        LOGGER.info("se ha creado: " + property.toString());
        propertyRepository.save(property);
        return new PropertyResponse(property);
    }

    public PropertyResponse updateProperty(Integer id, PropertyRequest propertyRequest, Integer token) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setEnvironments(propertyRequest.getPropertyEnvironments());
            property.setDimensions(propertyRequest.getPropertyDimensions());
            property.setValue(propertyRequest.getPropertyValue());
            property.setDescription(propertyRequest.getPropertyDescription());
            property.setImage(propertyRequest.getPropertyImage());
            property.setIdSection(sectionRepository.findById(propertyRequest.getPropertyIdSection()).orElse(null));
            property.setIdUser(userRepository.findById(token).get());
            propertyRepository.save(property);
            return new PropertyResponse(property);
        } else {
            //TODO raise exception
            return null;
        }
    }

    public PropertyResponse deleteProperty(Integer id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            propertyRepository.delete(property);
        } else {
            //TODO raise exception
        }
        return new PropertyResponse(property);
    }

}