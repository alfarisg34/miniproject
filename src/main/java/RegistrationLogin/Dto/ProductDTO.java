package RegistrationLogin.Dto;

public class ProductDTO {
	private int id;
	private String name;
	private String description;
	private Float price;
	private String pic;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String description, Float price, String pic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
