package com.example.online_contact_directory_backend.repository;

import com.example.online_contact_directory_backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

    @Transactional
    @Query(value = "select u from User u where u.email=:email and u.password=:password")
    public User findBySpecificFields(String email, String password);
}
