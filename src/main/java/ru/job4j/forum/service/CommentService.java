package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.repository.springdata.CommentRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void add(Comment comment) {
        comment.setCreated(new Date(System.currentTimeMillis()));
        commentRepository.save(comment);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Optional<Comment> findById(int id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentsByPostId(int postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}
