package ucb.buildingcare.buildingcare.dto;

public class UserRequest {
    //Esta clase es la que se encarga de recibir una peticion de User del front end
    //Mas frecuentemente el login
    
    private String username;
    private String password;

    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
