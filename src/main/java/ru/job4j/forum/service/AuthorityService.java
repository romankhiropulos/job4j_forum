package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.memory.AuthorityMemoryRep;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    private final AuthorityMemoryRep authMemoryRep;

    public AuthorityService(AuthorityMemoryRep authMemoryRep) {
        this.authMemoryRep = authMemoryRep;
    }

    public Optional<Authority> findByAuthority(String roleUser) {
        return authMemoryRep.findByAuthority(roleUser);
    }
}
