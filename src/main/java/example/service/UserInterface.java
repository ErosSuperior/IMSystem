package example.service;

import example.entities.User;

public interface UserInterface {
    User login(String username, String password);
}

