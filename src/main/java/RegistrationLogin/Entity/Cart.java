package RegistrationLogin.Entity;

import java.sql.Date;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
// import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
	@Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "username", referencedColumnName = "username")
	@Column(name = "username", length = 255)
	private String username;

	@Column(name = "dateTime", length = 255)
	private Date dateTime;

    @Column(name = "subTotalAll", length = 45)
	private Float subTotalAll;

    @Column(name = "paidStatus", length = 255)
	private String paidStatus;

    @Column(name = "deliveryMethode", length = 255)
	private String deliveryMethode;

    @Column(name = "paymentMethode", length = 255)
	private String paymentMethode;

    public Cart() {
    }

    public Cart(int id, String username, Date dateTime, Float subTotalAll, String paidStatus, String deliveryMethode,
            String paymentMethode) {
        this.id = id;
        this.username = username;
        this.dateTime = dateTime;
        this.subTotalAll = subTotalAll;
        this.paidStatus = paidStatus;
        this.deliveryMethode = deliveryMethode;
        this.paymentMethode = paymentMethode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Float getSubTotalAll() {
        return subTotalAll;
    }

    public void setSubTotalAll(Float subTotalAll) {
        this.subTotalAll = subTotalAll;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getDeliveryMethode() {
        return deliveryMethode;
    }

    public void setDeliveryMethode(String deliveryMethode) {
        this.deliveryMethode = deliveryMethode;
    }

    public String getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(String paymentMethode) {
        this.paymentMethode = paymentMethode;
    }
}
