package example.service;

import example.entities.User;

public interface UserInterface {
    User
    login(String email, String password);
}

