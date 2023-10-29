package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.CommonAreaRequest;
import ucb.buildingcare.buildingcare.dto.CommonAreaResponse;
import ucb.buildingcare.buildingcare.entity.CommonArea;
import ucb.buildingcare.buildingcare.repository.CommonAreaRepository;
import ucb.buildingcare.buildingcare.repository.SectionRepository;
import ucb.buildingcare.buildingcare.repository.TypeAreaRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommonAreaBl {
    //Esta clase es la que se encarga de la logica sobre las areas comunes
    //Requiere de las tablas:
    //CommonArea
    //TypeArea
    //Section

    Logger LOGGER = LoggerFactory.getLogger(CommonAreaBl.class);

    @Autowired
    private CommonAreaRepository commonAreaRepository;

    @Autowired
    private TypeAreaRepository typeAreaRepository;
    
    @Autowired
    private SectionRepository sectionRepository;

    public CommonAreaBl(CommonAreaRepository commonAreaRepository, TypeAreaRepository typeAreaRepository, SectionRepository sectionRepository) {
        this.commonAreaRepository = commonAreaRepository;
        this.typeAreaRepository = typeAreaRepository;
        this.sectionRepository = sectionRepository;
    }

    public BuildingcareResponse ListAllCommonAreas() {
        LOGGER.info("CommonAreaBl - ListAllCommonAreas");
        List<CommonArea> commonAreas = commonAreaRepository.findAll();
        LOGGER.info("el tamano de commonAreas List<CommonArea> es: "+ commonAreas.size());
        List<CommonAreaResponse> commonAreaResponses = new ArrayList<>();
        for (CommonArea commonArea : commonAreas) {
            LOGGER.info("en el for de List<CommonArea> commonAreas: "+ commonArea.toString());
            commonAreaResponses.add(new CommonAreaResponse(commonArea));
        }
        LOGGER.info("retornando new BuildingcareResponse(commonAreaResponses): "+ new BuildingcareResponse(commonAreaResponses).toString());
        return new BuildingcareResponse(commonAreaResponses);
    }

    public CommonAreaResponse getCommonAreaById(Integer id) throws BuildingcareException {
        CommonArea commonArea = commonAreaRepository.findById(id).orElse(null);
        if (commonArea != null) {
            return new CommonAreaResponse(commonArea);
        } else {
            throw new BuildingcareException("No se encontro Áreas Comunes con id "+id);
        }
    }

    public CommonAreaResponse createCommonArea(CommonAreaRequest commonAreaRequest) {
        CommonArea commonArea = new CommonArea();
        LOGGER.info("Entrando a crear Áreas Comunes BL");
        commonArea.setDescription(commonAreaRequest.getDescription());
        commonArea.setSectionId(sectionRepository.findById(commonAreaRequest.getIdSection()).orElse(null));
        commonArea.setTypeAreaId(typeAreaRepository.findById(commonAreaRequest.getIdTypeArea()).orElse(null));
        LOGGER.info("se ha creado: " + commonArea.toString());
        try {
            commonAreaRepository.save(commonArea);
        } catch (Exception e) {
            LOGGER.error("No se pudo guardar el elemento", e);
        }
        return new CommonAreaResponse(commonArea);
    }

    public CommonAreaResponse updateCommonArea(Integer id, CommonAreaRequest commonAreaRequest, Integer token ) throws BuildingcareException {
        CommonArea commonArea = commonAreaRepository.findById(id).orElse(null);
        if (commonArea != null) {
            commonArea.setDescription(commonAreaRequest.getDescription());
            commonArea.setSectionId(sectionRepository.findById(commonAreaRequest.getIdSection()).orElse(null));
            commonArea.setTypeAreaId(typeAreaRepository.findById(commonAreaRequest.getIdTypeArea()).orElse(null));
            try {
                commonAreaRepository.save(commonArea);
            } catch (Exception e) {
                LOGGER.error("No se pudo guardar el elemento", e);
            }
            return new CommonAreaResponse(commonArea);
        } else {
            throw new BuildingcareException("No se encontro Áreas Comunes con id "+id);
        }
    }

    public CommonAreaResponse deleteCommonArea(Integer id) throws BuildingcareException {
        CommonArea commonArea = commonAreaRepository.findById(id).orElse(null);
        if (commonArea != null) {
            commonAreaRepository.delete(commonArea);
            return new CommonAreaResponse(commonArea);
        } else {
            throw new BuildingcareException("No se encontro Áreas Comunes con id "+id);
        }
    }
}