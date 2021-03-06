package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.*;

@Repository
public class UserMemoryRep {

    private final Map<Integer, User> userMap = new HashMap<>();

    public Collection<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User save(User user) {
        return userMap.put(user.getId(), user);
    }

    public Optional<User> findByUsername(String username) {
        return userMap.values().stream().filter(
                user -> username.equals(user.getUsername())
        ).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userMap.values().stream().filter(
                user -> user.getUsername().equals(username) && user.getPassword().equals(password)
        ).findFirst();
    }
}
