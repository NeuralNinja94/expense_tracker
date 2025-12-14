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
    //Benutzer aktualisieren
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setBenutzername(user.getBenutzername());
            existingUser.setPasswort(user.getPasswort());
            // Weitere Felder können hier aktualisiert werden
            return userRepository.save(existingUser);
        }
        return null;
    }
    

    
    public void validateCredentials(String benutzername, String passwort){
        // Validierung der Anmeldeinformationen
        if (benutzername == null || benutzername.isBlank()) {
            throw new IllegalArgumentException("Bitte Benutzername eingeben");
            }
        if (passwort == null || passwort.isBlank()) {
            throw new IllegalArgumentException("Bitte Passwort eingeben");
        }

        User user = userRepository.findByBenutzername(benutzername)
                .orElseThrow(IllegalArgumentException::new);

        if (!user.getPasswort().equals(passwort)) {
            throw new IllegalArgumentException("Ungültiges Passwort");
        }
        
    }
    

}
