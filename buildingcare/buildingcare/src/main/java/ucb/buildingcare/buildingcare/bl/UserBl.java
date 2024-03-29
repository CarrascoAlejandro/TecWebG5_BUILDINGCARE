package ucb.buildingcare.buildingcare.bl;

import java.sql.Date;
import java.time.LocalDate;
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
import ucb.buildingcare.buildingcare.util.BuildingcareException;
import ucb.buildingcare.buildingcare.util.ValidatePassword;

@Service
public class UserBl {
    //Esta clase es la que se encarga de la logica sobre los usuarios
    //Requiere de las tablas:
    //User
    //TypeUser
    private static final Logger LOG = LoggerFactory.getLogger(UserBl.class);

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TypeUserRepository typeUserRepository;

    
    public UserBl(UserRepository userRepository, TypeUserRepository typeUserRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.typeUserRepository = typeUserRepository;
        this.emailService = emailService;
    }
    //login del usuario en base a nickname y password
    public UserResponse login(UserRequest userRequest) {
        try{
            LOG.info("llego a user service nickname : "+ userRequest.getUsername() + " y password : "+ userRequest.getPassword());
            User user = userRepository.findByUsenameAndPassword(userRequest.getUsername(), userRequest.getPassword()).get(0);
            LOG.info("se recupero un usuario");
            UserResponse response = new UserResponse(user);
            if ( //si la contraseña tiene mas de 3 meses de antiguedad se le avisa al usuario
                Date.valueOf(LocalDate.now())
                    .after(Date.valueOf(user.getPwLastUpdate()
                                            .toLocalDate()
                                            .plusMonths(3)))) {
                response.setWarnings(new String[]{"La contraseña ha expirado, por favor cambiala"});
            } else {
                response.setWarnings(new String[]{});
            }
            return response;
        } catch (RuntimeException e){
            LOG.warn("no se encontro al usuario");
            throw e;
        }
        
    }
    
    public UserResponse signUp(UserRequest signUpRequest) throws BuildingcareException{
        LOG.info("Registrando... user service nickname : "+ signUpRequest.getUsername() + " y password : "+ signUpRequest.getPassword());

        LOG.info("Validando password");
        try {
            ValidatePassword.validatePassword(signUpRequest.getPassword());
        } catch (Exception e) {
            LOG.error("Error en la validacion de la contraseña", e);
            throw new BuildingcareException(e.getMessage());
        }

        User user = new User();
        user.setName(signUpRequest.getName());
        user.setUsename(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setEmail(signUpRequest.getEmail());
        user.setCI(signUpRequest.getCi());
        user.setPhone(signUpRequest.getPhone());
        user.setIdTypeUser(typeUserRepository.findById(3).orElse(null));
        user.setPwLastUpdate(Date.valueOf(LocalDate.now()));
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

    public String resetPassword(String newPassword, String username) throws BuildingcareException {
        LOG.info("UserBl - resetPassword");
        LOG.info("Validando password");
        try {
            ValidatePassword.validatePassword(newPassword);
        } catch (Exception e) {
            LOG.error("Error en la validacion de la contraseña", e);
            throw new BuildingcareException(e.getMessage());
        }
        
        try {
            User user = userRepository.findByUsename(username).get(0);
            user.setPassword(newPassword);
            user.setPwLastUpdate(Date.valueOf(LocalDate.now()));
            try {
                userRepository.save(user);
            } catch (Exception e) {
                LOG.error("No se pudo guardar el elemento", e);
            }
            return "Contraseña cambiada con exito";
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("No se encontro el elemento");
        }
    }

    public String sendResetPasswordEmail(String username, String email) {
        LOG.info("UserBl - sendResetPasswordEmail");
        
        try{
            User user = userRepository.findByUsename(username).get(0);
            if(user.getEmail().equals(email)){
                emailService.sendResetPasswordEmail(email, username);
                return "Email enviado con exito";
            } else {
                LOG.error("El email no coincide con el usuario: " + email + " - " + user.getEmail());
                throw new RuntimeException("El email no coincide con el usuario");
            }
        } catch(IndexOutOfBoundsException e) {
            throw new RuntimeException("No se encontro el elemento");
        }
    }
}
