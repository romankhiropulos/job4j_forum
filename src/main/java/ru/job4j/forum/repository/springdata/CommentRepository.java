package ru.job4j.forum.repository.springdata;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findCommentsByPostId(int id);
}
