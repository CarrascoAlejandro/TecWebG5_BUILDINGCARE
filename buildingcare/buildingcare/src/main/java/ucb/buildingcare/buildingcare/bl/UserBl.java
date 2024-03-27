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
import ucb.buildingcare.buildingcare.entity.TypeUser;
import ucb.buildingcare.buildingcare.entity.User;
import ucb.buildingcare.buildingcare.repository.TypeUserRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareHash;

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
            BuildingcareHash hash = new BuildingcareHash();
            LOG.info("llego a user service nickname : "+ userRequest.getUsername() + " y password : "+ userRequest.getPassword());
            //recuperar el salt
            User user = userRepository.findByUsename(userRequest.getUsername()).get(0);
            byte[] salt = user.getSalt();
            //hashear el password
            String hashedPassword = hash.HashWithSalt(userRequest.getPassword(), salt);
            //comparar el password hasheado con el de la base
            if (hashedPassword.equals(user.getPassword())){
                LOG.info("se logeo un usuario");
                return new UserResponse(user);
            } else {
                LOG.warn("no se logeo un usuario");
                throw new RuntimeException("No se encontro el usuario");
            }
        } catch (RuntimeException e){
            LOG.warn("no se encontro al usuario");
            throw e;
        }
    }
    
    public UserResponse signUp(UserRequest signUpRequest){
        LOG.info("Registrando... user service nickname : "+ signUpRequest.getUsername() + " y password : "+ signUpRequest.getPassword());
        User user = new User(); 
        BuildingcareHash hash = new BuildingcareHash();
        user.setName(signUpRequest.getName());
        user.setUsename(signUpRequest.getUsername());
        //user.setPassword(signUpRequest.getPassword());
        byte[] salt = hash.getSalt();
        user.setPassword(hash.HashWithSalt(signUpRequest.getPassword(),salt));
        user.setEmail(signUpRequest.getEmail());
        user.setCI(signUpRequest.getCi());
        user.setPhone(signUpRequest.getPhone());
        user.setIdTypeUser(typeUserRepository.findById(3).orElse(null));
        user.setSalt(salt);
        userRepository.save(user);
        LOG.info("se registro un usuario");
        return new UserResponse(user);
    }

    public UserResponse updateUserData(UserResponse userRequestFull){
        LOG.info("UserBl - updateUserData "+ userRequestFull.toString());
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

    public BuildingcareResponse getAllUserTypes() {
        LOG.info("UserBl - getAllUserTypes");
        List<TypeUser> types = typeUserRepository.findAll();
        LOG.info("el tamano de types List<String> es: "+ types.size());
        List<TypeUser> typeResponses = new ArrayList<>();
        for (TypeUser type : types){
            LOG.info("en el for de list<String> types: "+ type.toString());
            typeResponses.add(type);
        }
        LOG.info("retornando new BuildingcareResponse(typeResponses): "+ new BuildingcareResponse(typeResponses).toString());
        return new BuildingcareResponse(typeResponses);
 
    }

    
}
