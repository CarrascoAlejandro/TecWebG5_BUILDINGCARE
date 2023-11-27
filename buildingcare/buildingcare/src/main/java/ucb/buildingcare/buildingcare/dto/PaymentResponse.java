package ucb.buildingcare.buildingcare.dto;

import ucb.buildingcare.buildingcare.entity.Payment;

public class PaymentResponse {
    //Formato para enviar los datos de un pago
    
    private Integer id;
    private String amount;
    private String date;
    private String concept;
    private String detail;
    private Integer idUserPays;
    private String nameUserPays;
    private Integer idUserReceives;
    private String nameUserReceives;

    public PaymentResponse() {
    }

    public PaymentResponse(Payment payment){
        this.id = payment.getId();
        this.amount = payment.getAmount().toString();
        this.date = payment.getDate().toString();
        this.concept = payment.getConcept();
        this.detail = payment.getDetail();
        this.idUserPays = payment.getIdUserPays().getIdUser();
        this.nameUserPays = payment.getIdUserPays().getName();
        this.idUserReceives = payment.getIdUserReceives().getIdUser();
        this.nameUserReceives = payment.getIdUserReceives().getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getNameUserPays() {
        return nameUserPays;
    }

    public void setNameUserPays(String nameUserPays) {
        this.nameUserPays = nameUserPays;
    }

    public Integer getIdUserReceives() {
        return idUserReceives;
    }

    public void setIdUserReceives(Integer idUserReceives) {
        this.idUserReceives = idUserReceives;
    }

    public String getNameUserReceives() {
        return nameUserReceives;
    }

    public void setNameUserReceives(String nameUserReceives) {
        this.nameUserReceives = nameUserReceives;
    }

    
}
