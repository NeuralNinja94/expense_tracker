package com.expensetracker.backend.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.User;



public interface UserRepository extends JpaRepository<User, Long>  {
// Benutzer nach Benutzernamen suchen
Optional<User> findByBenutzername(String benutzername);

// Benutzer nach E-Mail suchen
Optional<User> findByEmail(String email);



}