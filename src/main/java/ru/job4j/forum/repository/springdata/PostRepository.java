package ru.job4j.forum.repository.springdata;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
