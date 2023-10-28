package ucb.buildingcare.buildingcare.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentRequest {
    //Formato para recibir los datos de un pago

    private BigDecimal amount;
    private Date date;
    private String concept;
    private String detail;
    private Integer idUserPays;
    private Integer idUserReceives;

    public PaymentRequest() {
    }
    
    public PaymentRequest(BigDecimal amount, Date date, String concept, String detail, Integer idUserPays,
            Integer idUserReceives) {
        this.amount = amount;
        this.date = date;
        this.concept = concept;
        this.detail = detail;
        this.idUserPays = idUserPays;
        this.idUserReceives = idUserReceives;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getIdUserPays() {
        return idUserPays;
    }

    public void setIdUserPays(Integer idUserPays) {
        this.idUserPays = idUserPays;
    }

    public Integer getIdUserReceives() {
        return idUserReceives;
    }

    public void setIdUserReceives(Integer idUserReceives) {
        this.idUserReceives = idUserReceives;
    }
}
