package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.UserBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.UserRequest;
import ucb.buildingcare.buildingcare.dto.UserResponse;

@RestController
@RequestMapping("/api/v1/user")
public class UserAPI {

    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private final UserBl userService;

    
    public UserAPI(UserBl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllUsers() {
        LOG.info("ListAllUsers");
        BuildingcareResponse buildingcareResponse = userService.ListAllUsers();
        buildingcareResponse.setResponseCode("USER-0000");
        LOG.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }
    
    @PostMapping(path = "/login")
    public BuildingcareResponse login(@RequestBody UserRequest userRequest) {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setResponseCode("USER-0001");
            buildingcareResponse.setData(userService.login(userRequest));

        } catch (RuntimeException e) {
            buildingcareResponse.setResponseCode("USER-6001");
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @PostMapping(path = "/signup")
    public BuildingcareResponse signUp(@RequestBody UserRequest signUpRequest){
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setResponseCode("USER-0002");
            buildingcareResponse.setData(userService.signUp(signUpRequest));

        } catch (Exception e) {
            buildingcareResponse.setResponseCode("USER-6002");
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/update")
    public BuildingcareResponse updateUserData(@RequestBody UserResponse userRequestFull){
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setResponseCode("USER-0003");
            buildingcareResponse.setData(userService.updateUserData(userRequestFull));

        } catch (RuntimeException e) {
            buildingcareResponse.setResponseCode("USER-6003");
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }

    @GetMapping("/type/all") 
    public BuildingcareResponse getAllUserTypes(){
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setResponseCode("USER-0004");
            buildingcareResponse.setData(userService.getAllUserTypes().getData());

        } catch (RuntimeException e) {
            buildingcareResponse.setResponseCode("USER-6004");
            buildingcareResponse.setErrorMessage(e.getMessage());
        }
        return buildingcareResponse;
    }   
}