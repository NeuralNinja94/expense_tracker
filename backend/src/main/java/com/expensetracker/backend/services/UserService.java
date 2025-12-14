package com.expensetracker.backend.services;
import java.util.List;

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
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    //Neuen Benutzer erstellen
    public User createUser(User user) {
        return userRepository.save(user);
    }
    //Benutzer löschen
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    //Anmeldeinformationen validieren
    public void validateCredentials(String benutzername, String passwort){
        // Validierung der Anmeldeinformationen
        if (benutzername == null || benutzername.isBlank()) {
            throw new IllegalArgumentException("Bitte Benutzername eingeben");
            }
        if (passwort == null || passwort.isBlank()) {
            throw new IllegalArgumentException("Bitte Passwort eingeben");
        }
    }
    
    //Benutzer aktualisieren
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Benutzer nicht gefunden mit der ID: " + id));

        existingUser.setBenutzername(updatedUser.getBenutzername());
        existingUser.setPasswort(updatedUser.getPasswort());
        // Weitere Felder können hier aktualisiert werden

        return userRepository.save(existingUser);
    }


    

}
