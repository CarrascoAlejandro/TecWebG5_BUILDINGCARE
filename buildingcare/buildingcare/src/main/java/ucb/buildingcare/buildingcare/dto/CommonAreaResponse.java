package ucb.buildingcare.buildingcare.dto;

import ucb.buildingcare.buildingcare.entity.CommonArea;

public class CommonAreaResponse {
    //Esta clase es la que se encarga de enviar la respuesta sobre commonArea al front end
    private Integer id;
    private String commonAreaDescription;
    private Integer commonAreaSection;
    private String commonAreaTypeArea;

    public CommonAreaResponse() {
    }

    public CommonAreaResponse(CommonArea commonArea) {
        this.id = commonArea.getId();
        this.commonAreaDescription = commonArea.getDescription();
        this.commonAreaSection = commonArea.getSectionId().getId();
        this.commonAreaTypeArea = commonArea.getTypeAreaId().getType();
    }

    public Integer getId() {                                                        
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonAreaDescription() {
        return commonAreaDescription;
    }

    public void setCommonAreaDescription(String commonAreaDescription) {
        this.commonAreaDescription = commonAreaDescription;
    }

    public Integer getCommonAreaSection() {
        return commonAreaSection;
    }

    public void setCommonAreaSection(Integer commonAreaSection) {
        this.commonAreaSection = commonAreaSection;
    }

    public String getCommonAreaTypeArea() {
        return commonAreaTypeArea;
    }

    public void setCommonAreaTypeArea(String commonAreaTypeArea) {
        this.commonAreaTypeArea = commonAreaTypeArea;
    }
}
