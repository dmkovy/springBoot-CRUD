package ru.dmkovy.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dmkovy.springbootcrud.service.UserServiceJpa;
import ru.dmkovy.springbootcrud.model.User;

@Controller
public class UserController {

    private final UserServiceJpa userServiceJpa;

    @Autowired
    public UserController(UserServiceJpa userServiceJpa) {
        this.userServiceJpa = userServiceJpa;
    }

    @GetMapping("/")
    public String printAllUsers(Model model) {
        model.addAttribute("users", userServiceJpa.findAll());
        return "users";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServiceJpa.findById(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userServiceJpa.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceJpa.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userServiceJpa.deleteById(id);
        return "redirect:/";
    }
}
