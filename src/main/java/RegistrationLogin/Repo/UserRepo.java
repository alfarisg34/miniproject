package RegistrationLogin.Repo;

import RegistrationLogin.Dto.UserDTO;
import RegistrationLogin.Entity.User;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@EnableJpaRepositories
// @Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
    Optional<User> findOneByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    List<User> findAll(Specification<User> spec);

    @Modifying
    //DELETE FROM User WHERE product_id=1
    @Query("delete from User u where u.username = ?1")
    void deleteUserByUsername(String username);
    void save(UserDTO userDTO);

}
