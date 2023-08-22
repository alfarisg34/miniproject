package RegistrationLogin.Service;

import RegistrationLogin.Dto.ProductDTO;
// import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.Entity.Product;
import RegistrationLogin.Repo.ProductRepo;

// import RegistrationLogin.response.LoginResponse;
import RegistrationLogin.response.Response;

// import org.hibernate.mapping.List;
//import RegistrationLogin.payload.response.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import java.util.HashMap;
// import java.util.Map;
// import jakarta.annotation.Resource;
// import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

@Service
public class ProductImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Override
	public Response addProduct(Product productDTO) {
		// Map<String, String> data = new HashMap<>();
		Product Product1 = productRepo.findById(productDTO.getId());
		if (Product1 == null) {
			this.productRepo.save(productDTO);
			return new Response("Product create success", true);
		}
		
		// return new Response("Register Success", true , data);
		return new Response("Product create failed, Product name already created", false);
	}

	ProductDTO productDTO;

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();
		productRepo.findAll().forEach(products::add);
		return products;
	}

	@Override
	public List<Product> getAllProductOrderByName() {
		List<Product> products = new ArrayList<>();
		productRepo.findAllOrderByName().forEach(products::add);
		return products;
	}

	@Override
	public List<Product> getAllProductOrderByPrice() {
		List<Product> products = new ArrayList<>();
		productRepo.findAllOrderByPrice().forEach(products::add);
		return products;
	}

	@Override
	public Product getOneProduct(int id){
		Product product = productRepo.findById(id);
		return product;
	}

	@Override
	public Response updateProduct(int id, ProductDTO productDTO) {
		Product product1 = productRepo.findById(id);
		if (product1 != null) {
			// Product product = product1.get();
            product1.setName(productDTO.getName());
			product1.setDescription(productDTO.getDescription());
			product1.setPrice(productDTO.getPrice());
			product1.setPic(productDTO.getPic()); 
			productRepo.save(product1);
			return new Response("Update success", true);
		} else{
			return new Response("Update failed, Product not found", false);
		}
	}

	@Override
	public Response deleteProduct(int id) {
		Product product1 = productRepo.findById(id);
		if (product1 != null) {
			this.productRepo.deleteById(id);
			return new Response("Delete success", true);
		} else{
			return new Response("Delete failed, Product not found", false);
		}
	}
}
