package ru.job4j.forum.repository.springdata;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
