package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CommonArea")
public class CommonArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "TypeArea_id", nullable = false)
    private int typeAreaId;

    @Column(name = "Section_id", nullable = false)
    private int sectionId;

    // Constructor por defecto
    public CommonArea() {
    }

    public CommonArea(String description, int typeAreaId, int sectionId) {
        this.description = description;
        this.typeAreaId = typeAreaId;
        this.sectionId = sectionId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeAreaId() {
        return typeAreaId;
    }

    public void setTypeAreaId(int typeAreaId) {
        this.typeAreaId = typeAreaId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "CommonArea [id=" + id + ", description=" + description + ", typeAreaId=" + typeAreaId + ", sectionId=" + sectionId + "]";
    }
}
