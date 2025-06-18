package org.example.service.impl;

import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.UserRepository;
import org.example.service.UserInterface;

import java.util.Optional;

@Service
public class Userimpl implements UserInterface {

    @Autowired
    private UserRepository repo;

    @Override
    public User login(String email, String password) {
        Optional<User> user = repo.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }
}
