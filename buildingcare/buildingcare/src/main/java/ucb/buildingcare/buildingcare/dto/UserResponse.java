package ucb.buildingcare.buildingcare.dto;

import ucb.buildingcare.buildingcare.entity.User;

public class UserResponse {
    int idUser;
    String name;
    String usename;
    String email;
    String CI;
    String phone;
    String typeUser;
    String[] warnings;

    public UserResponse(int idUser, String name, String usename, String email, String cI, String phone, String typeUser, String[] warnings) {
        this.idUser = idUser;
        this.name = name;
        this.usename = usename;
        this.email = email;
        CI = cI;
        this.phone = phone;
        this.typeUser = typeUser;
        this.warnings = warnings;
    }

    public UserResponse(User user){
        this.idUser = user.getIdUser();
        this.name = user.getName();
        this.usename = user.getUsename();
        this.email = user.getEmail();
        this.CI = user.getCI();
        this.phone = user.getPhone();
        this.typeUser = user.getIdTypeUser().getPermission();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String cI) {
        CI = cI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String[] getWarnings() {
        return warnings;
    }

    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }

    @Override
    public String toString() {
        return "UserResponse [CI=" + CI + ", email=" + email + ", idUser=" + idUser + ", name=" + name + ", phone="
                + phone + ", typeUser=" + typeUser + ", usename=" + usename + "]";
    }
}
