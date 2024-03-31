package ucb.buildingcare.buildingcare.bl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.ResetPasswordRequest;
import ucb.buildingcare.buildingcare.dto.RoleAssignation;
import ucb.buildingcare.buildingcare.dto.UserRequest;
import ucb.buildingcare.buildingcare.dto.UserResponse;
import ucb.buildingcare.buildingcare.entity.Privilege;
import ucb.buildingcare.buildingcare.entity.TypeUser;
import ucb.buildingcare.buildingcare.entity.User;
import ucb.buildingcare.buildingcare.repository.TypeUserRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;
import ucb.buildingcare.buildingcare.util.ValidatePassword;
import ucb.buildingcare.buildingcare.util.BuildingcareHash;

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
            BuildingcareHash hash = new BuildingcareHash();
            LOG.info("llego a user service nickname : "+ userRequest.getUsername() + " y password : \""+ userRequest.getPassword() + "\"");
            //recuperar el salt
            User user = userRepository.findByUsename(userRequest.getUsername()).get(0);
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

            response.setRoleAssignation(permissionsFromUserType(user.getIdTypeUser()));
            
            byte[] salt = user.getSalt();
            //hashear el password
            String hashedPassword = hash.HashWithSalt(userRequest.getPassword(), salt);
            LOG.info(salt.toString());
            LOG.info(hashedPassword);
            LOG.info(user.getPassword());
            //comparar el password hasheado con el de la base
            if (hashedPassword.equals(user.getPassword())){
                LOG.info("se logeo un usuario");
                return response;
            } else {
                LOG.warn("no se logeo un usuario");
                throw new RuntimeException("El usuario o la contraseña son incorrectos");
            }
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
        BuildingcareHash hash = new BuildingcareHash();
        user.setName(signUpRequest.getName());
        user.setUsename(signUpRequest.getUsername());
        //user.setPassword(signUpRequest.getPassword());
        byte[] salt = hash.getSalt();
        user.setPassword(hash.HashWithSalt(signUpRequest.getPassword(),salt));
        user.setEmail(signUpRequest.getEmail());
        user.setCI(signUpRequest.getCi());
        user.setPhone(signUpRequest.getPhone());
         // Set base user privileges id = 4
        user.setIdTypeUser(typeUserRepository.findById(4).orElse(null));
        user.setPwLastUpdate(Date.valueOf(LocalDate.now()));
        user.setSalt(salt);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new BuildingcareException("El nombre de usuario ya existe");
        }
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

    public String resetPassword(ResetPasswordRequest request) throws BuildingcareException {
        LOG.info("UserBl - resetPassword");
        LOG.info("Validando password +\"" + request.getNewPassword() + "\"");
        try {
            ValidatePassword.validatePassword(request.getNewPassword());
        } catch (Exception e) {
            LOG.error("Error en la validacion de la contraseña", e);
            throw new BuildingcareException(e.getMessage());
        }
        
        try {
            User user = userRepository.findByUsename(request.getUsername()).get(0);

            BuildingcareHash hash = new BuildingcareHash();
            byte[] salt = user.getSalt();
            try {
                user.setPassword(hash.HashWithSalt(request.getNewPassword(), salt));
            } catch (IllegalArgumentException e) {
                LOG.error("Password must be different from the last 3 passwords", e);
                throw new BuildingcareException("La contraseña no puede ser igual a las ultimas 3 contraseñas");
            }

            user.setPwLastUpdate(Date.valueOf(LocalDate.now()));
            try {
                userRepository.save(user);
                return "Contraseña cambiada con exito";
            } catch (Exception e) {
                LOG.error("No se pudo guardar el elemento", e);
                throw new RuntimeException("No se pudo guardar el elemento");
            }
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
        } catch (MessagingException e) {
            LOG.error("No se pudo enviar el email", e);
            e.printStackTrace();
            throw new RuntimeException("No se pudo enviar el email");
        }
    }

    private RoleAssignation permissionsFromUserType(TypeUser typeUser) {
        RoleAssignation roleAssignation = new RoleAssignation();
        List<Privilege> privileges = typeUser.getPrivileges();
        Map<String, String> permissions = new HashMap<>();
        for (Privilege privilege : privileges) {
            permissions.put(privilege.getModule(), privilege.getAccessPrivilege().getDisplayName());
        }
        roleAssignation.setPrivileges(permissions);
        roleAssignation.setName(typeUser.getPermission());
        return roleAssignation;
    }
}
