package RegistrationLogin.Controller;

import RegistrationLogin.Dto.UserDTO;
import RegistrationLogin.Dto.LoginDTO;
import RegistrationLogin.Entity.User;
import RegistrationLogin.Service.UserService;
import RegistrationLogin.response.LoginResponse;
import RegistrationLogin.response.Response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO)
    {
        Response saveResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(saveResponse);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    } 

    @PostMapping(path = "/logout")
    public ResponseEntity<?> logoutUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse logoutResponse = userService.logoutUser(loginDTO);
        return ResponseEntity.ok(logoutResponse);
    } 
    
    @GetMapping("/get")
    public User findOneUser(@RequestParam String username){
        User user = userService.getOneUser(username);
        return user;
    }

    @GetMapping("/getAll")
    public List<User> findAll(){
        List<User> users = userService.getAllUser();
        return users;
        // Response getAllResponse = userService.addEmployee(employeeDTO);
        // return ResponseEntity.ok(getAllResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam String username, @RequestBody UserDTO userDTO){
        Response updateResponse = userService.updateUser(username,userDTO);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping("/delete/{username}")
    public ResponseEntity<?> delete(@PathVariable(value = "username") String username){
        Response deleteResponse = userService.deleteUser(username);
        return ResponseEntity.ok(deleteResponse);
    }
}
