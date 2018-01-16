package fr.n7.fut.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.n7.fut.model.users.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    User findById(int id);
    List<User> findAll();
}
