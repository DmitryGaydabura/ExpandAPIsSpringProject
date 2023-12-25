package com.example.expandapisspringproject.service;

import com.example.expandapisspringproject.dao.pojo.User;
import com.example.expandapisspringproject.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Boolean authenticate(String username, String rawPassword) {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println(user.isPresent());
        boolean isMatching = false;
        if(user.isPresent()){
            String storedPassword = user.get().getPassword();
            isMatching = checkPassword(rawPassword,storedPassword);
        }
        return isMatching;

    }

    public boolean checkPassword(String rawPassword, String storedHash) {
        return passwordEncoder.matches(rawPassword, storedHash);
    }
}
