package RegistrationLogin.Dto;

import java.sql.Date;

public class CartDTO {
	private int id;
	private String username;
	private Date dateTime;
	private Float subTotalAll;
	private String paidStatus;
	private String deliveryMethode;
	private String paymentMethode;

    public CartDTO() {
    }

    public CartDTO(int id, String username, Date dateTime, Float subTotalAll, String paidStatus, String deliveryMethode,
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
