package fr.n7.fut.repository;

import fr.n7.fut.model.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    User findById(int id);
}
