package ucb.buildingcare.buildingcare.dto;

public class UserDto {
        //Clase en desuso

    private int idUser;
    private String name;
    //Nota: Se puso en la base "usename" en vez de "username"
    private String usename;
    private String password;
    private String email;
    private String CI;
    private String phone;
    private int idTypeUser;
    private byte[] salt;

    public UserDto() {
    }

    public UserDto(int idUser, String name, String usename, String password, String email, String CI, String phone, int idTypeUser, byte[] salt) {
        this.idUser = idUser;
        this.name = name;
        this.usename = usename;
        this.password = password;
        this.email = email;
        this.CI = CI;
        this.phone = phone;
        this.idTypeUser = idTypeUser;
        this.salt = salt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", CI='" + CI + '\'' +
                ", phone='" + phone + '\'' +
                ", idTypeUser=" + idTypeUser +  '\'' +
                ", salt='" + salt +
                '}';
    }
}
