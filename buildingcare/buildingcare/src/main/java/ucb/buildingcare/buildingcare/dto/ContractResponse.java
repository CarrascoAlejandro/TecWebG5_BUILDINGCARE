package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;
import java.sql.Date;

import ucb.buildingcare.buildingcare.entity.Contract;

public class ContractResponse {
    //Esta clase es la que se encarga de enviar la respuesta sobre contract al front end
    private Integer id;
    private Date contractSignatureDate;
    private Date contractEndDate;
    private BigDecimal contractAmount;
    private Integer contractType;
    private Integer contractProperty;
    private Integer contractUser;
    private String contractOwner;

    public ContractResponse() {
    }

    public ContractResponse(Contract contract) {
        this.id = contract.getId();
        this.contractSignatureDate = (Date) contract.getSignatureDate();
        this.contractEndDate = (Date) contract.getEndDate();
        this.contractAmount = contract.getAmount();
        this.contractType = contract.getIdTypeContract().getId();
        this.contractProperty = contract.getIdProperty().getId();
        this.contractUser = contract.getIdUser().getIdUser();
        this.contractOwner = contract.getIdProperty().getIdUser().getName();
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getContractSignatureDate() {
        return contractSignatureDate;
    }

    public void setContractSignatureDate(Date contractSignatureDate) {
        this.contractSignatureDate = contractSignatureDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Integer getContractProperty() {
        return contractProperty;
    }

    public void setContractProperty(Integer contractProperty) {
        this.contractProperty = contractProperty;
    }

    public Integer getContractUser() {
        return contractUser;
    }

    public void setContractUser(Integer contractUser) {
        this.contractUser = contractUser;
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner;
    }
}
