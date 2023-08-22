package RegistrationLogin.Service;

import RegistrationLogin.Dto.CartItemDTO;
import RegistrationLogin.Entity.CartItem;

import java.util.List;
// import java.util.Optional;

import RegistrationLogin.response.Response;
public interface CartItemService {
    Response addCartItem(CartItem cartItemDTO);
    List<CartItem> getAllCartItem();
    Response updateCartItem(int id,CartItemDTO cartItemDTO);
    Response deleteCartItem(int id);
    CartItem getOne(int id);
}