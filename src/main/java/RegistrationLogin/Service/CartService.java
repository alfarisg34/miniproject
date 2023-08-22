package RegistrationLogin.Service;

import RegistrationLogin.Dto.CartDTO;
import RegistrationLogin.Entity.Cart;

import java.util.List;
// import java.util.Optional;

import RegistrationLogin.response.Response;
public interface CartService {
    Response addCart(Cart cartDTO);
    List<Cart> getAllCart();
    Response updateCart(int id,CartDTO cartDTO);
    Response deleteCart(int id);
    Cart getOne(int id);
}