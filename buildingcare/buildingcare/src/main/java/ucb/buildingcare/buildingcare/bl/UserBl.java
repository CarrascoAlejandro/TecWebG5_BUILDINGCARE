package ucb.buildingcare.buildingcare.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.UserRequest;
import ucb.buildingcare.buildingcare.entity.User;
import ucb.buildingcare.buildingcare.repository.UserRepository;

@Service
public class UserBl {
    private static final Logger LOG = LoggerFactory.getLogger(UserBl.class);
    @Autowired
    private final UserRepository userRepository;

    
    public UserBl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //login del usuario en base a nickname y password
    public UserRequest login(String username, String password) {
        try{
            LOG.info("llego a user service nickname : "+ username + " y password : "+ password);
            User user = userRepository.findByUsenameAndPassword(username, password).get(0);
            LOG.info("se recupero un usuario");
            return new UserRequest(user.getUsename(), user.getPassword());
        }catch(RuntimeException e){
            LOG.warn("no se encontro al usuario");
            return null;
        }
        
    }
    //aun no se usará
    public User signUp(User user){
        return userRepository.save(user);
    }
}
