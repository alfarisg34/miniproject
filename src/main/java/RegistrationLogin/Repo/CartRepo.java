package RegistrationLogin.Repo;

import RegistrationLogin.Dto.CartDTO;
import RegistrationLogin.Entity.Cart;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface CartRepo extends JpaRepository<Cart, Integer>
{
    Cart findById(int id);
    List<Cart> findAll(Specification<Cart> spec);
    void deleteById(int id);
    void save(CartDTO cartDTO);
}
