package RegistrationLogin.Controller;

import RegistrationLogin.Dto.ProductDTO;
import RegistrationLogin.Entity.Product;
import RegistrationLogin.Service.ProductService;
import RegistrationLogin.response.Response;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> saveProduct(@RequestBody Product productDTO)
    {
        Response saveResponse = productService.addProduct(productDTO);
        return ResponseEntity.ok(saveResponse);
    } 
    
    @GetMapping("/get")
    public Product findOneProduct(@RequestParam int id){
        Product product = productService.getOneProduct(id);
        return product;
    }

    @GetMapping("/getAll")
    public List<Product> findAll(){
        List<Product> Products = productService.getAllProduct();
        return Products;
        // Response getAllResponse = ProductService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @GetMapping("/getAllOrderByName")
    public List<Product> findAllOrderByName(){
        List<Product> Products = productService.getAllProductOrderByName();
        return Products;
        // Response getAllResponse = ProductService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @GetMapping("/getAllOrderByPrice")
    public List<Product> findAllOrderByPrice(){
        List<Product> Products = productService.getAllProductOrderByPrice();
        return Products;
        // Response getAllResponse = ProductService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id, @RequestBody ProductDTO productDTO){
        Response updateResponse = productService.updateProduct(id,productDTO);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        Response deleteResponse = productService.deleteProduct(id);
        return ResponseEntity.ok(deleteResponse);
    }
}
