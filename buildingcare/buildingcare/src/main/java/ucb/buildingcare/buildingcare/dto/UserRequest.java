package ucb.buildingcare.buildingcare.dto;

public class UserRequest {
    //Esta clase es la que se encarga de recibir una peticion de User del front end
    //Mas frecuentemente el login
    
    private String username;
    private String password;
    private String name;
    private String email;
    private String ci;
    private String phone;

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

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getCi() {
        return ci;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public void setCI(String ci) {
        this.ci = ci;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
