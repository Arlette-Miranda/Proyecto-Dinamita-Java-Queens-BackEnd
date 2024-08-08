package com.yoatzin.app.service;

import com.yoatzin.app.model.Comment;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment createComment(Comment comment); // Método para crear un comentario.

    Optional<Comment> getCommentById(Long id); // Método para obtener un comentario por ID.

    Iterable<Comment> getAllComments(); // Método para obtener todos los comentarios.

    Comment updateComment(Long id, Comment newCommentData); // Método para actualizar un comentario.

    void deleteComment(Long id); // Método para eliminar un comentario.
}

