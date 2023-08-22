package RegistrationLogin.Dto;

// import java.sql.Date;

public class CartItemDTO {
	private int id;
	private int idProduct;
	private int count;
	private Float subTotal;

    public CartItemDTO() {
    }

    public CartItemDTO(int id, int idProduct, int count, Float subTotal) {
        this.id = id;
        this.idProduct = idProduct;
        this.count = count;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }
}
