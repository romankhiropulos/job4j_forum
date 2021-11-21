package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.memory.PostMemoryRep;

import java.util.*;

@Service
public class PostService {

    private final PostMemoryRep postRepository;

    public PostService(PostMemoryRep postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        post.setCreated(new Date(System.currentTimeMillis()));
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
