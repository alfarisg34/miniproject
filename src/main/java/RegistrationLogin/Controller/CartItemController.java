package RegistrationLogin.Controller;

import RegistrationLogin.Dto.CartItemDTO;
import RegistrationLogin.Entity.CartItem;
import RegistrationLogin.Service.CartItemService;
import RegistrationLogin.response.Response;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> saveCart(@RequestBody CartItem cartItemDTO)
    {
        Response saveResponse = cartItemService.addCartItem(cartItemDTO);
        return ResponseEntity.ok(saveResponse);
    } 
    
    @GetMapping("/get")
    public CartItem findOneCart(@RequestParam int id){
        CartItem cartItem = cartItemService.getOne(id);
        return cartItem;
    }

    @GetMapping("/getAll")
    public List<CartItem> findAll(){
        List<CartItem> cartItems = cartItemService.getAllCartItem();
        return cartItems;
        // Response getAllResponse = ProductService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody CartItemDTO cartItemDTO){
        Response updateResponse = cartItemService.updateCartItem(id,cartItemDTO);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        Response deleteResponse = cartItemService.deleteCartItem(id);
        return ResponseEntity.ok(deleteResponse);
    }
}
