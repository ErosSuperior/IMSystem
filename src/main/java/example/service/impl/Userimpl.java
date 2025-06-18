package example.service.impl;

import example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.repository.UserRepository;
import example.service.UserInterface;

import java.util.Optional;

@Service
public class Userimpl implements UserInterface {

    @Autowired
    private UserRepository repo;

    @Override
    public User login(String email, String password) {
        Optional<User> user = repo.findByEmail(email);
        if (user.isPresent() && user.get().getPassword_hash().equals(password)) {
            return user.get();
        }
        return null;
    }
}
