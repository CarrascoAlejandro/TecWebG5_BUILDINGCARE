package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ContractRequest {
    //Esta clase es la que se encarga de recibir una peticion de Contract del front end
    private Date signatureDate;
    private Date endDate;
    private BigDecimal amount;
    private Integer idProperty;
    // private Integer idUser;
    private Integer idType;

    public ContractRequest() {
    }

    public ContractRequest(Date signatureDate, Date endDate, BigDecimal amount, Integer idProperty, Integer idType) {
        this.signatureDate = signatureDate;
        this.endDate = endDate;
        this.amount = amount;
        this.idProperty = idProperty;
        // this.idUser = idUser;
        this.idType = idType;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

}
