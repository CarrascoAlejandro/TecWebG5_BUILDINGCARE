package ucb.buildingcare.buildingcare.dto;

public class CommonAreaRequest {
    //Esta clase es la que se encarga de recibir una peticion de CommonArea del front end
    private String description;
    private Integer idSection;
    private Integer idTypeArea;

    public CommonAreaRequest(String description, Integer idSection, Integer idTypeArea) {
        this.description = description;
        this.idSection = idSection;
        this.idTypeArea = idTypeArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public Integer getIdTypeArea() {
        return idTypeArea;
    }

    public void setIdTypeArea(Integer idTypeArea) {
        this.idTypeArea = idTypeArea;
    }
}
