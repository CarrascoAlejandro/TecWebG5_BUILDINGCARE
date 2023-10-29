package ucb.buildingcare.buildingcare.dto;

public class TypeUserDto {
        //Clase en desuso

    private int id;
    private String permission;

    public TypeUserDto() {
    }

    public TypeUserDto(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "TypeUserDto{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
