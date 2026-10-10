package com.example.docker_dem.Controller;

import com.example.docker_dem.Entity.User;
import com.example.docker_dem.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @PostMapping("/add")
    public void addUser(@RequestBody User user) throws IOException {
        System.out.println("PostMapping");
        userService.addUser(user);
    }

    @GetMapping("/get")
    public List<User> getUsers()throws IOException{
        System.out.println("Get Mapping");
        return userService.getUsers();
    }

    @GetMapping("/get/names")
    public List<String> getUserName() throws IOException{
        return userService.getUserName();
    }
}
