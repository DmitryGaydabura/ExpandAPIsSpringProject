package com.example.expandapisspringproject.dao.repository;

import com.example.expandapisspringproject.dao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsernameAndPassword(String username, String password);

}
