package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "concept", length = 50, nullable = false)
    private String concept;

    @Column(name = "detail", length = 100, nullable = false)
    private String detail;

    @Column(name = "idUserPays", nullable = false)
    private int idUserPays;

    @Column(name = "idUserReceives", nullable = false)
    private int idUserReceives;

    // Constructor por defecto
    public Payment() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdUserPays() {
        return idUserPays;
    }

    public void setIdUserPays(int idUserPays) {
        this.idUserPays = idUserPays;
    }

    public int getIdUserReceives() {
        return idUserReceives;
    }

    public void setIdUserReceives(int idUserReceives) {
        this.idUserReceives = idUserReceives;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", amount=" + amount + ", date=" + date + ", concept=" + concept + ", detail=" + detail + ", idUserPays=" + idUserPays + ", idUserReceives=" + idUserReceives + "]";
    }
}
