package com.expensetracker.backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.backend.entities.User;



public interface UserRepository extends JpaRepository<User, Long>  {
    


}