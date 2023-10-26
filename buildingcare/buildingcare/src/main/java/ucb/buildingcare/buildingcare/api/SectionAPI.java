package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.SectionBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;

@RestController
@RequestMapping(path = "/api/v1/section")
public class SectionAPI {
    //Esta API se encarga de la logica sobre las secciones
    //De momento solo aplica para listar las secciones para el combo box de la vista de propiedades
    //Requiere de los servicios:
    //SectionBl

    Logger LOGGER = LoggerFactory.getLogger(SectionAPI.class);
    
    @Autowired
    private SectionBl sectionBl;

    public SectionAPI(SectionBl sectionBl) {
        this.sectionBl = sectionBl;
    }

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllSections() {
        LOGGER.info("ListAllSections");
        BuildingcareResponse buildingcareResponse = sectionBl.ListAllSections();
        buildingcareResponse.setResponseCode("SECT-0000");
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }
}
