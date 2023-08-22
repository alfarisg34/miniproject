package RegistrationLogin.Controller;

import RegistrationLogin.Dto.CartDTO;
import RegistrationLogin.Entity.Cart;
import RegistrationLogin.Service.CartService;
import RegistrationLogin.response.Response;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> saveCart(@RequestBody Cart cartDTO)
    {
        Response saveResponse = cartService.addCart(cartDTO);
        return ResponseEntity.ok(saveResponse);
    } 
    
    @GetMapping("/get")
    public Cart findOneCart(@RequestParam int id){
        Cart cart = cartService.getOne(id);
        return cart;
    }

    @GetMapping("/getAll")
    public List<Cart> findAll(){
        List<Cart> carts = cartService.getAllCart();
        return carts;
        // Response getAllResponse = ProductService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody CartDTO cartDTO){
        Response updateResponse = cartService.updateCart(id,cartDTO);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        Response deleteResponse = cartService.deleteCart(id);
        return ResponseEntity.ok(deleteResponse);
    }
}
