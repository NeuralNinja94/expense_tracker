package com.expensetracker.backend.services;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.expensetracker.backend.entities.User;
import com.expensetracker.backend.repositories.UserRepository;







@Service
public class UserService {

    // Methoden zum Verwalten von Benutzern (CRUD-Operationen) können hier hinzugefügt werden
    private final UserRepository userRepository;
    //Konstruktor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Alle Benutzer abrufen
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Benutzer nach ID abrufen
    public User getUserById(@NonNull Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benutzer nicht gefunden mit der ID: " + id));
    }
    //Neuen Benutzer erstellen
    public User createUser(@NonNull User user) {
        return userRepository.save(user);
    }
    //Benutzer löschen
    public void deleteUser(@NonNull Long id) {
        userRepository.deleteById(id);
    }
    //Anmeldeinformationen validieren
    public void validateCredentials(@NonNull String benutzername, @NonNull String passwort){
        // Validierung der Anmeldeinformationen
        if (benutzername.isBlank()) {
            throw new IllegalArgumentException("Bitte Benutzername eingeben");
            }
        if (passwort.isBlank()) {
            throw new IllegalArgumentException("Bitte Passwort eingeben");
        }
    }
    
    //Benutzer aktualisieren
    public User updateUser(@NonNull Long id, @NonNull User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benutzer nicht gefunden mit der ID: " + id));

        existingUser.setBenutzername(updatedUser.getBenutzername());
        existingUser.setPasswort(updatedUser.getPasswort());
        

        return userRepository.save(existingUser);
    }

    

    

}
