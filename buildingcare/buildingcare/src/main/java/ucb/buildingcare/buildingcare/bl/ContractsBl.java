package ucb.buildingcare.buildingcare.bl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.ContractRequest;
import ucb.buildingcare.buildingcare.dto.ContractResponse;
import ucb.buildingcare.buildingcare.entity.Contract;
import ucb.buildingcare.buildingcare.entity.TypeContract;
import ucb.buildingcare.buildingcare.repository.ContractRepository;
import ucb.buildingcare.buildingcare.repository.PropertyRepository;
import ucb.buildingcare.buildingcare.repository.TypeContractRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@Service
public class ContractsBl {
    //Esta clase es la que se encarga de la logica sobre los contratos
    //Requiere de las tablas:
    //Contract
    //Property
    //TypeContract
    //User

    Logger LOGGER = LoggerFactory.getLogger(ContractsBl.class);

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private TypeContractRepository typeContractRepository;
    @Autowired
    private UserRepository userRepository;

    public ContractsBl(ContractRepository contractRepository, PropertyRepository propertyRepository, TypeContractRepository typeContractRepository, UserRepository userRepository) {
        this.contractRepository = contractRepository;
        this.propertyRepository = propertyRepository;
        this.typeContractRepository = typeContractRepository;
        this.userRepository = userRepository;
    }

    public BuildingcareResponse getContracts(Integer type) throws BuildingcareException{
        LOGGER.info("ContractBl - ListAllContracts - type: "+ type);
        List<Contract> contracts = new ArrayList<>();
        if(type == null || type == 0){
            LOGGER.info("el type es: null");
            contracts = contractRepository.findAll();
        }else{
            LOGGER.info("el type es: "+ type);
            contracts = contractRepository.findByIdTypeContract(typeContractRepository.findById(type).orElse(null));
        }
        
        LOGGER.info("el tamano de contracts List<Contract> es: "+ contracts.size());
        List<ContractResponse> contractResponses = new ArrayList<>();
        for (Contract contract : contracts) {
            LOGGER.info("en el for de List<Contract> contracts: "+ contract.toString());
            contractResponses.add(new ContractResponse(contract));
        }
        LOGGER.info("retornando new BuildingcareResponse(contractResponses): "+ new BuildingcareResponse(contractResponses).toString());
        return new BuildingcareResponse(contractResponses);
    }

    public BuildingcareResponse getTypeContract() throws BuildingcareException{
        LOGGER.info("ContractBl - TypesContract");
        List<TypeContract> typeContract = typeContractRepository.findAll();
        LOGGER.info("el tamano de TypeContract List<TypeContract> es: "+ typeContract.size());
        if (typeContract.size() == 0) {
            LOGGER.error("No se encontraron tipos de contratos");
            throw new BuildingcareException("No se encontraron tipos de contratos");
        }
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse(typeContract);
        LOGGER.info("retornando new BuildingcareResponse(typeContracts): "+ buildingcareResponse.toString());
        return buildingcareResponse;
    }

    public ContractResponse getContractById(Integer id) throws BuildingcareException {
        Contract contract = contractRepository.findById(id).orElse(null);
        if (contract != null) {
            return new ContractResponse(contract);
        } else {
            throw new BuildingcareException("No se encontro el contrato con id "+id);
        }
    }
    
    public ContractResponse createContract(ContractRequest contractRequest, Integer token) {
        Contract contract = new Contract();
        LOGGER.info("Entrando a crear contrato BL");
        contract.setSignatureDate(contractRequest.getSignatureDate());
        contract.setEndDate(contractRequest.getEndDate());
        contract.setAmount(contractRequest.getAmount());
        contract.setIdProperty(propertyRepository.findById(contractRequest.getIdProperty()).orElse(null));
        contract.setIdTypeContract(typeContractRepository.findById(contractRequest.getIdType()).orElse(null));
        contract.setIdUser(userRepository.findById(token).get());
        LOGGER.info("se ha creado: " + contract.toString());
        try {
            contractRepository.save(contract);
        } catch (Exception e) {
            LOGGER.error("No se pudo guardar el elemento", e);
        }
        return new ContractResponse(contract);
    }
    
    public ContractResponse updateContract(Integer id, ContractRequest contractRequest, Integer token) throws BuildingcareException {
        Contract contract = contractRepository.findById(id).orElse(null);
        if (contract != null) {
            contract.setSignatureDate(contractRequest.getSignatureDate());
            contract.setEndDate(contractRequest.getEndDate());
            contract.setAmount(contractRequest.getAmount());
            contract.setIdProperty(propertyRepository.findById(contractRequest.getIdProperty()).orElse(null));
            contract.setIdTypeContract(typeContractRepository.findById(contractRequest.getIdType()).orElse(null));
            contract.setIdUser(userRepository.findById(token).get());
            try {
                contractRepository.save(contract);
            } catch (Exception e) {
                LOGGER.error("No se pudo guardar el elemento", e);
            }
            return new ContractResponse(contract);
        } else {
            throw new BuildingcareException("No se encontro el contrato con id "+id);
        }
    }

    public ContractResponse deleteContract(Integer id) throws BuildingcareException {
        Contract contract = contractRepository.findById(id).orElse(null);
        if (contract != null) {
            contractRepository.delete(contract);
            return new ContractResponse(contract);
        } else {
            throw new BuildingcareException("No se encontro el contrato con id "+id);
        }
    }
}
