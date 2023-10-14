package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "signatureDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date signatureDate;

    @Column(name = "endDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "idProperty", nullable = false)
    private int idProperty;

    @Column(name = "idUser", nullable = false)
    private int idUser;

    @Column(name = "idTypeContract", nullable = false)
    private int idTypeContract;

    // Constructor por defecto
    public Contract() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTypeContract() {
        return idTypeContract;
    }

    public void setIdTypeContract(int idTypeContract) {
        this.idTypeContract = idTypeContract;
    }

    @Override
    public String toString() {
        return "Contract [id=" + id + ", signatureDate=" + signatureDate + ", endDate=" + endDate + ", amount=" + amount + ", idProperty=" + idProperty + ", idUser=" + idUser + ", idTypeContract=" + idTypeContract + "]";
    }
}
