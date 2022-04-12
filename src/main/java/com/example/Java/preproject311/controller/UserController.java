package com.example.Java.preproject311.controller;

import com.example.Java.preproject311.model.User;
import com.example.Java.preproject311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/add")
    public String createUserForm(User user) {
        return "new_user";
    }

    @PostMapping("/add")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
