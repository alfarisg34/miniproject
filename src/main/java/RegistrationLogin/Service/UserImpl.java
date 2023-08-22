package RegistrationLogin.Service;

import RegistrationLogin.Dto.UserDTO;
import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.Entity.User;
import RegistrationLogin.Repo.UserRepo;

import RegistrationLogin.response.LoginResponse;
import RegistrationLogin.response.Response;

// import org.hibernate.mapping.List;
//import RegistrationLogin.payload.response.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// import java.util.HashMap;
// import java.util.Map;
// import jakarta.annotation.Resource;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Response addUser(UserDTO userDTO) {
		// Map<String, String> data = new HashMap<>();
		User user1 = userRepo.findByUsername(userDTO.getUsername());
		if (user1 == null) {
			User user = new User(
				userDTO.getUsername(), 
				this.passwordEncoder.encode(userDTO.getPassword()),
				"USER" 
				);
			userRepo.save(user);
			return new Response("Register Success", true);
		}
		
		// return new Response("Register Success", true , data);
		return new Response("Register failed, username already registered", false);
	}

	UserDTO userDTO;

	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		// String msg = "";
		User user1 = userRepo.findByUsername(loginDTO.getUsername());
		if (user1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> user = userRepo.findOneByUsernameAndPassword(loginDTO.getUsername(),
						encodedPassword);
				if (user.isPresent()) {
					return new LoginResponse("Login Success", true);
				} else {
					return new LoginResponse("Login Failed", false);
				}
			} else {
				return new LoginResponse("password Not Match", false);
			}
		} else {
			return new LoginResponse("Username not exits", false);
		}
	}

	@Override
	public LoginResponse logoutUser(LoginDTO loginDTO) {
		// String msg = "";
		User user1 = userRepo.findByUsername(loginDTO.getUsername());
		if (user1 != null) {
			return new LoginResponse("Logout Success", true);
		} else {
			return new LoginResponse("Logout Failed", false);
		}
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getOneUser(String username){
		User user = userRepo.findByUsername(username);
		return user;
	}

	@Override
	public Response updateUser(String username, UserDTO userDTO) {
		User user1 = userRepo.findByUsername(userDTO.getUsername());
		if (user1 != null) {
            user1.setUsername(userDTO.getUsername());
			user1.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
			user1.setRole(userDTO.getRole());   
			userRepo.save(user1);
			return new Response("Update success", true);
		} else{
			return new Response("Update failed, user not found", false);
		}
	}

	@Override
	public Response deleteUser(String username) {
		User user1 = userRepo.findByUsername(username);
		if (user1 != null) {
			this.userRepo.deleteUserByUsername(username);
			return new Response("Delete success", true);
		} else{
			return new Response("Delete failed, user not found", false);
		}
	}
}
