package fr.n7.fut.repository;

import fr.n7.fut.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
