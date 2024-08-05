package com.adobe.prj.orderapp.security.dao;

import com.adobe.prj.orderapp.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, String> {
    // since email is unique, we will find by Email
    Optional<User> findByEmail(String email);
}
