package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorityMemoryRep {

    private final Map<Integer, Authority> postMap = new HashMap<>();

    public AuthorityMemoryRep() {
        postMap.put(1, Authority.of(1, "ROLE_USER"));
        postMap.put(2, Authority.of(2, "ROLE_ADMIN"));
    }

    public Optional<Authority> findByAuthority(String roleUser) {
        return postMap.values().stream()
                .filter(authority -> roleUser.equals(authority.getAuthority())).findFirst();
    }
}
