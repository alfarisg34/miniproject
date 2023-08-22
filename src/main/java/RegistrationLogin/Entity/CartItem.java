package RegistrationLogin.Entity;

// import java.sql.Date;

import jakarta.persistence.Column;
// import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
	@Column(name = "id", length = 45)
	private int id;

	@Column(name = "idProduct", length = 45)
	private int idProduct;

	@Column(name = "count", length = 45)
	private int count;

    @Column(name = "subTotal", length = 45)
	private Float subTotal;

    public CartItem() {
    }

    public CartItem(int id, int idProduct, int count, Float subTotal) {
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
