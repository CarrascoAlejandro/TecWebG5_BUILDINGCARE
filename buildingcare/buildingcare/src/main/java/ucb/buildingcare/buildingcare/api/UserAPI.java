package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.UserBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.UserRequest;

@RestController
@RequestMapping("/api/v1/login")
public class UserAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private final UserBl userService;

    
    public UserAPI(UserBl userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public BuildingcareResponse login(@RequestBody UserRequest userRequest) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        UserRequest user;
        String password=userRequest.getPassword();
        String username=userRequest.getUsername();
        try{
            user = userService.login(username, password);
            if(user== null){
                LOG.warn("no se encontro al usuario " + userRequest.getUsername());
                return buildingcareResponse;
            }else{
                LOG.info("el usuario llego a login api");
            }
        }catch(Exception e){ //TODO crear excepción específica
            LOG.error("no se pudo hacer login", e);
            return buildingcareResponse;
        }
        buildingcareResponse.setData(user);
        buildingcareResponse.setResponseCode("PROP-0001");
        return buildingcareResponse;
    }
    

    
}
