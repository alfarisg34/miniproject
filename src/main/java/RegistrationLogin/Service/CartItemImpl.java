package RegistrationLogin.Service;

import RegistrationLogin.Dto.CartItemDTO;
// import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.Entity.CartItem;
import RegistrationLogin.Repo.CartItemRepo;

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
public class CartItemImpl implements CartItemService {
	@Autowired
	private CartItemRepo cartItemRepo;
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Override
	public Response addCartItem(CartItem cartItemDTO) {
		// Map<String, String> data = new HashMap<>();
		CartItem cart1 = cartItemRepo.findById(cartItemDTO.getId());
		System.out.println(cart1);
		if (cart1 == null) {
			this.cartItemRepo.save(cartItemDTO);
			return new Response("Cart Item create success", true);
		}
		
		// return new Response("Register Success", true , data);
		return new Response("Cart Item create failed, Cart Item already created", false);
	}

	CartItemDTO cartItemDTO;

	@Override
	public List<CartItem> getAllCartItem() {
		List<CartItem> cartItems = new ArrayList<>();
		cartItemRepo.findAll().forEach(cartItems::add);
		return cartItems;
	}

	@Override
	public CartItem getOne(int id){
		CartItem cartItem = cartItemRepo.findById(id);
		return cartItem;
	}

	@Override
	public Response updateCartItem(int id, CartItemDTO cartItemDTO) {
		// CartItem cartItem1 = cartItemRepo.findByIdProduct(id);
		CartItem cartItem1 = cartItemRepo.findById(id);
		if (cartItem1 != null) {
			// Cart Cart = cart1.get();
            cartItem1.setId(cartItemDTO.getId());
			cartItem1.setIdProduct(cartItemDTO.getIdProduct());
			cartItem1.setCount(cartItemDTO.getCount());
			cartItem1.setSubTotal(cartItemDTO.getSubTotal()); 
			cartItemRepo.save(cartItem1);
			return new Response("Update success", true);
		} else{
			return new Response("Update failed, Cart Item not found", false);
		}
	}

	@Override
	public Response deleteCartItem(int id) {
		CartItem cartItem1 = cartItemRepo.findById(id);
		if (cartItem1 != null) {
			this.cartItemRepo.deleteById(id);
			return new Response("Delete success", true);
		} else{
			return new Response("Delete failed, Cart Item not found", false);
		}
	}
}
