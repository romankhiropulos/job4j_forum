package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.springdata.AuthorityRepository;

import java.util.Optional;

@Service
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Optional<Authority> findByAuthority(String roleUser) {
        return authorityRepository.findByAuthority(roleUser);
    }
}
