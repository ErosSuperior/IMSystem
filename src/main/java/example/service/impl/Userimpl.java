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

    public UserRepository getRepo() {
        return repo;
    }

    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User login(String username, String password) {
        Optional<User> user = repo.findByUsername(username);
        if (user.isPresent() && user.get().getPassword_hash().equals(password)) {
            return user.get();
        }
        return null;
    }


}
