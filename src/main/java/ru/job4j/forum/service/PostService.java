package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.springdata.PostRepository;

import java.util.*;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        Optional<Post> postFromDb = postRepository.findById(post.getId());
        if (postFromDb.isEmpty()) {
            post.setCreated(new Date(System.currentTimeMillis()));
            postRepository.save(post);
        } else {
            Post updatablePost = postFromDb.get();
            updatablePost.setDescription(post.getDescription());
            updatablePost.setName(post.getName());
            postRepository.save(updatablePost);
        }
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
