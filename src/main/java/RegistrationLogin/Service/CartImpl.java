package RegistrationLogin.Service;

import RegistrationLogin.Dto.CartDTO;
// import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.Entity.Cart;
import RegistrationLogin.Repo.CartRepo;

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
public class CartImpl implements CartService {
	@Autowired
	private CartRepo cartRepo;
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Override
	public Response addCart(Cart cartDTO) {
		// Map<String, String> data = new HashMap<>();
		Cart cart1 = cartRepo.findById(cartDTO.getId());
		if (cart1 == null) {
			this.cartRepo.save(cartDTO);
			return new Response("Cart create success", true);
		}
		
		// return new Response("Register Success", true , data);
		return new Response("Cart create failed, Cart name already created", false);
	}

	CartDTO cartDTO;

	@Override
	public List<Cart> getAllCart() {
		List<Cart> carts = new ArrayList<>();
		cartRepo.findAll().forEach(carts::add);
		return carts;
	}

	@Override
	public Cart getOne(int id){
		Cart cart = cartRepo.findById(id);
		return cart;
	}

	@Override
	public Response updateCart(int id, CartDTO cartDTO) {
		Cart cart1 = cartRepo.findById(id);
		if (cart1 != null) {
			// Cart Cart = cart1.get();
            cart1.setUsername(cartDTO.getUsername());
			cart1.setDateTime(cartDTO.getDateTime());
			cart1.setSubTotalAll(cartDTO.getSubTotalAll());
			cart1.setPaidStatus(cartDTO.getPaidStatus()); 
			cart1.setDeliveryMethode(cartDTO.getDeliveryMethode()); 
			cart1.setPaymentMethode(cartDTO.getPaymentMethode()); 
			cartRepo.save(cart1);
			return new Response("Update success", true);
		} else{
			return new Response("Update failed, Cart not found", false);
		}
	}

	@Override
	public Response deleteCart(int id) {
		Cart cart1 = cartRepo.findById(id);
		if (cart1 != null) {
			this.cartRepo.deleteById(id);
			return new Response("Delete success", true);
		} else{
			return new Response("Delete failed, Cart not found", false);
		}
	}
}
