package ucb.buildingcare.buildingcare.api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.buildingcare.buildingcare.bl.CommonAreaBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.CommonAreaRequest;

@RestController
@RequestMapping(path = "/api/v1/commonarea")
public class CommonAreaAPI {
    //Esta API se encarga de la logica sobre las areas comunes
    //Requiere de los servicios:
    //commonAreaBl

    Logger LOGGER = LoggerFactory.getLogger(CommonAreaAPI.class);

    @Autowired
    private CommonAreaBl commonAreaBl;

    public CommonAreaAPI(CommonAreaBl commonAreaBl) {
        this.commonAreaBl = commonAreaBl;
    }

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllCommonAreas() {
        LOGGER.info("ListAllCommonAreas");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse = commonAreaBl.ListAllCommonAreas();
            buildingcareResponse.setResponseCode("CARE-0000");
            LOGGER.info("se obtuvieron todas las areas comunes: "+ buildingcareResponse.toString());
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("CARE-6000");
            LOGGER.info("no se pudieron obtener todas las areas comunes: "+ buildingcareResponse.toString());
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @GetMapping(path = "/{id}")
    public BuildingcareResponse getCommonAreaById(@PathVariable Integer id) {
        LOGGER.info("getCommonAreaById: id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(commonAreaBl.getCommonAreaById(id));
            buildingcareResponse.setResponseCode("CARE-0000");
            LOGGER.info("se obtuvo el area comun: "+ buildingcareResponse.toString());
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("CARE-6000");
            LOGGER.info("no se pudo obtener el area comun: "+ buildingcareResponse.toString());
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @PostMapping()
    public BuildingcareResponse createCommonArea(@RequestBody CommonAreaRequest commonAreaRequest, @RequestHeader Integer token){
        LOGGER.info("Creando area comun");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(commonAreaBl.createCommonArea(commonAreaRequest));
            buildingcareResponse.setResponseCode("CARE-0001");
            LOGGER.info("se creo el area comun: "+ buildingcareResponse.toString());
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("CARE-6001");
            LOGGER.info("no se pudo crear el area comun: "+ buildingcareResponse.toString());
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}")
    public BuildingcareResponse updateCommonArea(@PathVariable Integer id, @RequestBody CommonAreaRequest commonAreaRequest, @RequestHeader Integer token){
        LOGGER.info("Actualizando area comun");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(commonAreaBl.updateCommonArea(id, commonAreaRequest,token));
            buildingcareResponse.setResponseCode("CARE-0002");
            LOGGER.info("se actualizo el area comun: "+ buildingcareResponse.toString());
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("CARE-6002");
            LOGGER.info("no se pudo actualizar el area comun: "+ buildingcareResponse.toString());
        }
        return buildingcareResponse;
    }

    @DeleteMapping(path = "/{id}")
    public BuildingcareResponse deleteCommonArea(@PathVariable Integer id){
        LOGGER.info("Eliminando area comun");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(commonAreaBl.deleteCommonArea(id));
            buildingcareResponse.setResponseCode("CARE-0003");
            LOGGER.info("se elimino el area comun: "+ buildingcareResponse.toString());
        } catch (Exception e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("CARE-6003");
            LOGGER.info("no se pudo eliminar el area comun: "+ buildingcareResponse.toString());
        }
        return buildingcareResponse;
    }

    @GetMapping(path = "/type")
    public BuildingcareResponse listAllCommonAreaTypes() {
        LOGGER.info("ListAllCommonAreaTypes");
        BuildingcareResponse buildingcareResponse = commonAreaBl.listAllCommonAreaTypes();
        buildingcareResponse.setResponseCode("CARE-0004");
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }
}
