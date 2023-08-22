package RegistrationLogin.Repo;

import RegistrationLogin.Dto.ProductDTO;
import RegistrationLogin.Entity.Product;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// import java.util.Optional;
// import java.util.Optional;

@Transactional
@EnableJpaRepositories
// @Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{
    Product findById(int id);
    List<Product> findAll(Specification<Product> spec);
    void deleteById(int id);
    void save(ProductDTO ProductDTO);

    @Modifying
    //SELECT * FROM Cart_item;
    @Query("SELECT u from Product u ORDER BY u.name ASC")
    List<Product> findAllOrderByName();

    @Modifying
    //SELECT * FROM Cart_item;
    @Query("SELECT u from Product u ORDER BY u.price ASC")
    List<Product> findAllOrderByPrice();
}
