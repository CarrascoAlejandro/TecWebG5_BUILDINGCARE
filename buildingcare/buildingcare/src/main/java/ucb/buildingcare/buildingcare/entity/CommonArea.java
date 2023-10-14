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

    @Column(name = "idTypeArea", nullable = false)
    private int idTypeArea;

    @ManyToOne
    @JoinColumn(name = "idSection", referencedColumnName = "id")
    private Section idSection;

    // Constructor por defecto
    public CommonArea() {
    }

    public CommonArea(String description, int typeAreaId, Section sectionId) {
        this.description = description;
        this.idTypeArea = typeAreaId;
        this.idSection = sectionId;
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
        return idTypeArea;
    }

    public void setTypeAreaId(int typeAreaId) {
        this.idTypeArea = typeAreaId;
    }

    public Section getSectionId() {
        return idSection;
    }

    public void setSectionId(Section sectionId) {
        this.idSection = sectionId;
    }

    @Override
    public String toString() {
        return "CommonArea [id=" + id + ", description=" + description + ", typeAreaId=" + idTypeArea + ", sectionId=" + idSection + "]";
    }
}
