package RegistrationLogin.Service;

import RegistrationLogin.Dto.ProductDTO;
import RegistrationLogin.Entity.Product;

import java.util.List;
// import java.util.Optional;

import RegistrationLogin.response.Response;
public interface ProductService {
    Response addProduct(Product ProductDTO);
    List<Product> getAllProduct();
    List<Product> getAllProductOrderByName();
    List<Product> getAllProductOrderByPrice();
    Response updateProduct(int id,ProductDTO ProductDTO);
    Response deleteProduct(int id);
    Product getOneProduct(int id);
}