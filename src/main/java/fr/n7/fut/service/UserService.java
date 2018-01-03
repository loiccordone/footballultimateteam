package fr.n7.fut.service;

import fr.n7.fut.model.users.User;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);
}
