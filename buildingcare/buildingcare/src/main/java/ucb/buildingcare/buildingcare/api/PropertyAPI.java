package ucb.buildingcare.buildingcare.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1/property")
public class PropertyAPI {
    
    @Autowired
    private PropertyBl propertyBl;

    @GetMapping(path = "/all")
    public List<PropertyResponse> ListAllProperties() {
        return propertyBl.ListAllProperties();
    }

    @GetMapping(path = "/{id}")
    public PropertyResponse getPropertyById(@PathVariable Integer id) {
        return propertyBl.getPropertyById(id);
    }

    @PostMapping()
    public PropertyResponse createProperty(@RequestBody PropertyRequest propertyRequest) {
        return propertyBl.createProperty(propertyRequest);
    }

    @PutMapping(path = "/{id}")
    public PropertyResponse updateProperty(@PathVariable Integer id, @RequestBody PropertyRequest propertyRequest) {
        return propertyBl.updateProperty(id, propertyRequest);
    }

    @DeleteMapping(path = "/{id}")
    public PropertyResponse deleteProperty(@PathVariable Integer id) {
        return propertyBl.deleteProperty(id);
    }
    
}
