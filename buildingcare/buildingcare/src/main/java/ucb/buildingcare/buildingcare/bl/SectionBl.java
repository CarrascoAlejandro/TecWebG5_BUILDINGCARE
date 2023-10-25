package ucb.buildingcare.buildingcare.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.repository.SectionRepository;

@Service
public class SectionBl {
    
    @Autowired
    private SectionRepository sectionRepository;

    public SectionBl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    public BuildingcareResponse ListAllSections() {
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        buildingcareResponse.setData(sectionRepository.findAll());
        return buildingcareResponse;
    }
}
