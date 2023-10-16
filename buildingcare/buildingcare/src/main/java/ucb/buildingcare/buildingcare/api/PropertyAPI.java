package ucb.buildingcare.buildingcare.api;

//import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Property;
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

@RestController
@RequestMapping(path = "/api/v1/property")
public class PropertyAPI {

    @Autowired
    private PropertyBl propertyBl;

    public PropertyAPI(PropertyBl propertyBl) {
        this.propertyBl = propertyBl;
    }

    

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllProperties() {
        BuildingcareResponse buildingcareResponse = propertyBl.ListAllProperties();
        buildingcareResponse.setResponseCode("PROP-0000");
        return buildingcareResponse;
    }

    @GetMapping(path = "/{id}")
    public BuildingcareResponse getPropertyById(@PathVariable Integer id) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        
        buildingcareResponse.setData(propertyBl.getPropertyById(id));
        buildingcareResponse.setResponseCode("PROP-0000");

        return buildingcareResponse;
    }

    @PostMapping()
    public BuildingcareResponse createProperty(@RequestBody PropertyRequest propertyRequest, @RequestHeader Integer token) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();

        buildingcareResponse.setData(propertyBl.createProperty(propertyRequest, token));
        buildingcareResponse.setResponseCode("PROP-0001");

        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}")
    public BuildingcareResponse updateProperty(@PathVariable Integer id, @RequestBody PropertyRequest propertyRequest, @RequestHeader Integer token) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();

        buildingcareResponse.setData(propertyBl.updateProperty(id, propertyRequest, token));
        buildingcareResponse.setResponseCode("PROP-0002");

        return buildingcareResponse;
    }

    @DeleteMapping(path = "/{id}")
    public BuildingcareResponse deleteProperty(@PathVariable Integer id) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();

        buildingcareResponse.setData(propertyBl.deleteProperty(id));
        buildingcareResponse.setResponseCode("PROP-0003");

        return buildingcareResponse;
    }
    
}
