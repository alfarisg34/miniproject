package RegistrationLogin.Repo;

import RegistrationLogin.Dto.CartItemDTO;
import RegistrationLogin.Entity.CartItem;

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
public interface CartItemRepo extends JpaRepository<CartItem, Integer>
{
    CartItem findById(int id);
    List<CartItem> findAll(Specification<CartItem> spec);
    void deleteById(int id);
    void save(CartItemDTO cartItemDTO);

    @Modifying
    //SELECT * FROM Cart_item;
    @Query("SELECT u from CartItem u where u.idProduct = ?1")
    void findByIdProduct(int idProduct);
}
