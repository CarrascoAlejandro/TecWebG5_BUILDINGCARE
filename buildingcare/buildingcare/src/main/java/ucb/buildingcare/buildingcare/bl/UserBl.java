package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.UserRequest;
import ucb.buildingcare.buildingcare.dto.UserResponse;
import ucb.buildingcare.buildingcare.entity.User;
import ucb.buildingcare.buildingcare.repository.TypeUserRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;

@Service
public class UserBl {
    //Esta clase es la que se encarga de la logica sobre los usuarios
    //Requiere de las tablas:
    //User
    //TypeUser
    private static final Logger LOG = LoggerFactory.getLogger(UserBl.class);
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TypeUserRepository typeUserRepository;

    
    public UserBl(UserRepository userRepository, TypeUserRepository typeUserRepository) {
        this.userRepository = userRepository;
        this.typeUserRepository = typeUserRepository;
    }
    //login del usuario en base a nickname y password
    public UserResponse login(UserRequest userRequest) {
        try{
            LOG.info("llego a user service nickname : "+ userRequest.getUsername() + " y password : "+ userRequest.getPassword());
            User user = userRepository.findByUsenameAndPassword(userRequest.getUsername(), userRequest.getPassword()).get(0);
            LOG.info("se recupero un usuario");
            return new UserResponse(user);
        } catch (RuntimeException e){
            LOG.warn("no se encontro al usuario");
            throw e;
        }
        
    }
    
    public UserResponse signUp(UserRequest signUpRequest){
        LOG.info("Registrando... user service nickname : "+ signUpRequest.getUsername() + " y password : "+ signUpRequest.getPassword());
        User user = new User();
        user.setUsename(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setIdTypeUser(typeUserRepository.findById(3).orElse(null));
        userRepository.save(user);
        LOG.info("se registro un usuario");
        return new UserResponse(user);
    }

    public UserResponse updateUserData(UserResponse userRequestFull){
        User user = userRepository.findById(userRequestFull.getIdUser()).orElse(null);
        if (user != null){
            user.setName(userRequestFull.getName());
            user.setUsename(userRequestFull.getUsename());
            user.setEmail(userRequestFull.getEmail());
            user.setCI(userRequestFull.getCI());
            user.setPhone(userRequestFull.getPhone());
            user.setIdTypeUser(typeUserRepository.findByPermission(userRequestFull.getTypeUser()).get(0));
            try {
                userRepository.save(user);
            } catch (Exception e) {
                LOG.error("No se pudo guardar el elemento", e);
            }
            return new UserResponse(user);
        } else {
            throw new RuntimeException("No se encontro el elemento");
        }
        
    }

    public BuildingcareResponse ListAllUsers() {
        LOG.info("UserBl - ListAllUsers");
        List<User> users = userRepository.findAll();
        LOG.info("el tamano de users List<User> es: "+ users.size());
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users){
            LOG.info("en el for de list<User> users: "+ user.toString());
            userResponses.add(new UserResponse(user));
        }
        LOG.info("retornando new BuildingcareResponse(userResponses): "+ new BuildingcareResponse(userResponses).toString());
        return new BuildingcareResponse(userResponses);
    }
}
