package ucb.buildingcare.buildingcare.dto;

public class TypePostDto {
    //Clase en desuso
    private int id;
    private String category;

    public TypePostDto() {
    }

    public TypePostDto(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "TypePostDto{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}