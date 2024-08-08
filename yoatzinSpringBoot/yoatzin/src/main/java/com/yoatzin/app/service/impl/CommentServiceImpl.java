package com.yoatzin.app.service.impl;

import com.yoatzin.app.model.Comment;
import com.yoatzin.app.repository.CommentRepository;
import com.yoatzin.app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        // Guardar y devolver el nuevo comentario
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        // Obtener el comentario por ID
        return commentRepository.findById(id);
    }

    @Override
    public Iterable<Comment> getAllComments() {
        // Obtener todos los comentarios
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Long id, Comment newCommentData) {
        // Buscar el comentario existente por ID
        return commentRepository.findById(id)
                .map(comment -> {
                    // Actualizar los campos del comentario
                    comment.setComment(newCommentData.getComment());
                    comment.setUser(newCommentData.getUser()); // Actualizar la relación con User
                    // Guardar y devolver el comentario actualizado
                    return commentRepository.save(comment);
                }).orElseThrow(() -> new IllegalArgumentException("Comment not found")); // Lanza excepción si no se encuentra el comentario
    }

    @Override
    public void deleteComment(Long id) {
        // Eliminar el comentario por ID
        commentRepository.deleteById(id);
    }
}
