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
import ucb.buildingcare.buildingcare.repository.TypePropertyRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@Service
public class PropertyBl {
    //Esta clase es la que se encarga de la logica sobre las propiedades, sus propietarios y su descripcion
    //Requiere de las tablas:
    //Property
    //User
    //Section
    //TypeProperty

    Logger LOGGER = LoggerFactory.getLogger(PropertyBl.class);

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private TypePropertyRepository typePropertyRepository;

    public PropertyBl(PropertyRepository propertyRepository, UserRepository userRepository, SectionRepository sectionRepository, TypePropertyRepository typePropertyRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
        this.sectionRepository = sectionRepository;
        this.typePropertyRepository = typePropertyRepository;
    }
    public BuildingcareResponse ListAllProperties() {
        LOGGER.info("PropertyBl - ListAllProperties");
        List<Property> properties = propertyRepository.findAllReverseOrder();
        LOGGER.info("el tamano de properties List<Property> es: "+ properties.size());
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        for (Property property : properties) {
            LOGGER.info("en el for de List<Property> properties: "+ property.toString());
            propertyResponses.add(new PropertyResponse(property));
        }
        LOGGER.info("retornando new BuildingcareResponse(propertyResponses): "+ new BuildingcareResponse(propertyResponses).toString());
        return new BuildingcareResponse(propertyResponses);
    }

    public PropertyResponse getPropertyById(Integer id) throws BuildingcareException {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            return new PropertyResponse(property);
        } else {
            throw new BuildingcareException("No se encontro la propedad con id "+id);
        }
    }

    //Filtrar propiedades según su propietario
    public BuildingcareResponse getPropertyByOwnerId(Integer id) throws BuildingcareException{
        LOGGER.info("PropertyBl - getPropertyByOwnerId "+ id);
        List<Property> properties = propertyRepository.findByIdUser(userRepository.findById(id).orElse(null));
        LOGGER.info("el tamano de properties List<Property> es: "+ properties.size());
        if (properties.size() == 0) {
            LOGGER.error("No se encontro la propedades con id "+id);
            throw new BuildingcareException("No se encontro la propedades con id "+id);
        }
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        for (Property property : properties) {
            LOGGER.info("en el for de List<Property> properties: "+ property.toString());
            propertyResponses.add(new PropertyResponse(property));
        }
        LOGGER.info("retornando new BuildingcareResponse(propertyResponses): "+ new BuildingcareResponse(propertyResponses).toString());
        return new BuildingcareResponse(propertyResponses);
    }

    //Filtrar propiedades por tipo y sección
    public BuildingcareResponse getPropertyByTypeAndSection(Integer idType, Integer idSection) throws BuildingcareException{
        LOGGER.info("PropertyBl - getPropertyByTypeAndSection "+ idType + " " + idSection);
        List<Property> properties = new ArrayList<>();
        List<PropertyResponse> propertyResponses = new ArrayList<>();
        if (idType != 0 && idSection != 0) {
            properties = propertyRepository.findByIdTypePropertyAndIdSection(typePropertyRepository.findById(idType).orElse(null), sectionRepository.findById(idSection).orElse(null));
        } else if (idType != 0) {
            properties = propertyRepository.findByIdTypeProperty(typePropertyRepository.findById(idType).orElse(null));
        } else if (idSection != 0) {
            properties = propertyRepository.findByIdSection(sectionRepository.findById(idSection).orElse(null));
        } else {
            return this.ListAllProperties();
        }
        LOGGER.info("el tamano de properties List<Property> es: "+ properties.size());
        if (properties.size() == 0) {
            LOGGER.error("No se encontro la propedades con los parametros indicados");
            throw new BuildingcareException("No se encontro la propedades con los parametros indicados");
        }
        for (Property property : properties) {
            LOGGER.info("en el for de List<Property> properties: "+ property.toString());
            propertyResponses.add(new PropertyResponse(property));
        }
        LOGGER.info("retornando new BuildingcareResponse(propertyResponses): "+ new BuildingcareResponse(propertyResponses).toString());
        return new BuildingcareResponse(propertyResponses);
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
        property.setIdTypeProperty(typePropertyRepository.findById(propertyRequest.getPropertyIdType()).orElse(null));
        property.setIdUser(userRepository.findById(token).get());
        LOGGER.info("se ha creado: " + property.toString());
        try {
            propertyRepository.save(property);
        } catch (Exception e) {
            LOGGER.error("No se pudo guardar el elemento", e);
        }
        return new PropertyResponse(property);
    }

    public PropertyResponse updateProperty(Integer id, PropertyRequest propertyRequest, Integer token) throws BuildingcareException {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            property.setEnvironments(propertyRequest.getPropertyEnvironments());
            property.setDimensions(propertyRequest.getPropertyDimensions());
            property.setValue(propertyRequest.getPropertyValue());
            property.setDescription(propertyRequest.getPropertyDescription());
            property.setImage(propertyRequest.getPropertyImage());
            property.setIdSection(sectionRepository.findById(propertyRequest.getPropertyIdSection()).orElse(null));
            property.setIdTypeProperty(typePropertyRepository.findById(propertyRequest.getPropertyIdType()).orElse(null));
            property.setIdUser(userRepository.findById(token).get());
            try {
                propertyRepository.save(property);
            } catch (Exception e) {
                LOGGER.error("No se pudo guardar el elemento", e);
            }
            return new PropertyResponse(property);
        } else {
            throw new BuildingcareException("No se encontro la propedad con id "+id);
        }
    }

    public PropertyResponse deleteProperty(Integer id) throws BuildingcareException {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property != null) {
            propertyRepository.delete(property);
        } else {
            throw new BuildingcareException("No se encontro la propedad con id "+id);
        }
        return new PropertyResponse(property);
    }

    public BuildingcareResponse listAllPropertyTypes() {
        LOGGER.info("PropertyBl - listAllPropertyTypes");
        return new BuildingcareResponse(typePropertyRepository.findAll());
    }

}