package com.expensetracker.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.backend.entities.User;
import com.expensetracker.backend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    
    //Abhängigkeit zu UserService
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Abrufen aller Benutzer
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //Abrufen eines Benutzers nach ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    //Erstellen eines neuen Benutzers
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    //Löschen eines Benutzers
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    //Aktualisieren eines Benutzers
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    

    
    
}
