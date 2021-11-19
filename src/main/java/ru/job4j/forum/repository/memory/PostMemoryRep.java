package ru.job4j.forum.repository.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.*;

@Repository
public class PostMemoryRep {

    private final Map<Integer, Post> postMap = new HashMap<>();

    private final UserMemoryRep userMemoryRep;

    public PostMemoryRep(UserMemoryRep userMemoryRep) {
        this.userMemoryRep = userMemoryRep;
        fillTestPosts();
    }

    public Post save(Post post) {
        postMap.put(post.getId(), post);
        return post;
    }

    public void deleteById(int id) {
        postMap.remove(id);
    }

    public Collection<Post> findAll() {
        return new ArrayList<>(postMap.values());
    }

    public Optional<Post> findById(int id) {
        return Optional.of(postMap.get(id));
    }

    public void delete(Post post) {
        postMap.remove(post.getId());
    }

    private void fillTestPosts() {
        User user1 = User.of(1, "user1", "password1");
        User user2 = User.of(2, "user2", "password2");
        User user3 = User.of(3, "user3", "password3");
        Post post1 = Post.of(1, "Post1", "Big mistake1", new Date(), user1);
        Post post2 = Post.of(2, "Post2", "Big mistake2", new Date(), user2);
        Post post3 = Post.of(3, "Post3", "Big mistake3", new Date(), user3);
        postMap.put(post1.getId(), post1);
        postMap.put(post2.getId(), post2);
        postMap.put(post3.getId(), post3);
        userMemoryRep.save(user1);
        userMemoryRep.save(user2);
        userMemoryRep.save(user3);
    }
}
