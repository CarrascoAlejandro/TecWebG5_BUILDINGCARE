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

    @ManyToOne
    @JoinColumn(name = "idProperty", referencedColumnName = "id")
    private Property idProperty;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idTypeContract", referencedColumnName = "id")
    private TypeContract idTypeContract;

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

    public Property getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Property idProperty) {
        this.idProperty = idProperty;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public TypeContract getIdTypeContract() {
        return idTypeContract;
    }

    public void setIdTypeContract(TypeContract idTypeContract) {
        this.idTypeContract = idTypeContract;
    }

    @Override
    public String toString() {
        return "Contract [id=" + id + ", signatureDate=" + signatureDate + ", endDate=" + endDate + ", amount=" + amount + ", idProperty=" + idProperty + ", idUser=" + idUser + ", idTypeContract=" + idTypeContract + "]";
    }
}
