//TODO: volver response y request
package ucb.buildingcare.buildingcare.dto;

public class SectionDto {
    private int id;
    private String name;
    private String location;
    private int idUser;

    public SectionDto() {
    }

    public SectionDto(int id, String name, String location, int idUser) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "SectionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
