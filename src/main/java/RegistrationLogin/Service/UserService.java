package RegistrationLogin.Service;

import RegistrationLogin.Dto.UserDTO;
import RegistrationLogin.Entity.User;

import java.util.List;

import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.response.LoginResponse;
import RegistrationLogin.response.Response;
public interface UserService {
    Response addUser(UserDTO userDTO);
    List<User> getAllUser();
    LoginResponse loginUser(LoginDTO loginDTO);
    LoginResponse logoutUser(LoginDTO loginDTO);
    Response updateUser(String username,UserDTO userDTO);
    Response deleteUser(String username);
    User getOneUser(String username);
}
