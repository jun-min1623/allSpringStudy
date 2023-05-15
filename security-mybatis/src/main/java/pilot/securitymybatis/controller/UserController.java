package pilot.securitymybatis.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pilot.securitymybatis.model.User;
import pilot.securitymybatis.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/alluser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/insertUser")
    public void insertUserData(@RequestBody User user){
        userService.insertUserData(user);
    }

    @GetMapping("loginPage")
    public String loginPage(){
        return "loginpage";
    }
}
