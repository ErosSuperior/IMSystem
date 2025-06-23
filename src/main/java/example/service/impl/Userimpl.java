package example.service.impl;

import example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.repository.UserRepo;
import example.service.UserInterface;

import java.util.Optional;

@Service
public class Userimpl implements UserInterface {

    @Autowired
    private UserRepo repo;

    public UserRepo getRepo() {
        return repo;
    }

    public void setRepo(UserRepo repo) {
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
