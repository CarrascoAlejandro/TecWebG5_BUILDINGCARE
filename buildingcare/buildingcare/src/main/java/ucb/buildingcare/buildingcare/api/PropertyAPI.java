package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.PropertyBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PropertyRequest;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@RestController
@RequestMapping(path = "/api/v1/property")
public class PropertyAPI {
    //Esta API se encarga de la logica sobre las propiedades, sus propietarios y su descripcion
    //Requiere de los servicios:
    //PropertyBl

    Logger LOGGER = LoggerFactory.getLogger(PropertyAPI.class);
    
    @Autowired
    private PropertyBl propertyBl;

    public PropertyAPI(PropertyBl propertyBl) {
        this.propertyBl = propertyBl;
    }

    

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllProperties() {
        LOGGER.info("ListAllProperties");
        BuildingcareResponse buildingcareResponse = propertyBl.ListAllProperties();
        buildingcareResponse.setResponseCode("PROP-0000");
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @GetMapping(path = "/{id}")
    public BuildingcareResponse getPropertyById(@PathVariable Integer id) {
        LOGGER.info("getPropertyById: id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        
        try {
            buildingcareResponse.setData(propertyBl.getPropertyById(id));
            buildingcareResponse.setResponseCode("PROP-0000");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("PROP-6000");
        }

        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @PostMapping()
    public BuildingcareResponse createProperty(@RequestBody PropertyRequest propertyRequest, @RequestHeader Integer token) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        LOGGER.info("Entrando a crear propiedad");
        buildingcareResponse.setData(propertyBl.createProperty(propertyRequest, token));
        LOGGER.info("Saliendo de crear propiedad");
        buildingcareResponse.setResponseCode("PROP-0001");

        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}")
    public BuildingcareResponse updateProperty(@PathVariable Integer id, @RequestBody PropertyRequest propertyRequest, @RequestHeader Integer token) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();

        try {
            buildingcareResponse.setData(propertyBl.updateProperty(id, propertyRequest, token));
            buildingcareResponse.setResponseCode("PROP-0002");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("PROP-6002");
        }

        return buildingcareResponse;
    }

    @DeleteMapping(path = "/{id}")
    public BuildingcareResponse deleteProperty(@PathVariable Integer id) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();

        try {
            buildingcareResponse.setData(propertyBl.deleteProperty(id));
            buildingcareResponse.setResponseCode("PROP-0003");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("PROP-6003");
        }
        

        return buildingcareResponse;
    }

    @GetMapping(path = "/type")
    public BuildingcareResponse listAllPropertyTypes() {
        BuildingcareResponse buildingcareResponse = propertyBl.listAllPropertyTypes();
        buildingcareResponse.setResponseCode("PROP-0004");
        return buildingcareResponse;
    }
    
}
