package com.expensetracker.backend.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.expensetracker.backend.entities.User;
import com.expensetracker.backend.repositories.UserRepository;



@Service
public class UserService {

    // Methoden zum Verwalten von Benutzern (CRUD-Operationen) können hier hinzugefügt werden
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Alle Benutzer abrufen
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    
    
}
