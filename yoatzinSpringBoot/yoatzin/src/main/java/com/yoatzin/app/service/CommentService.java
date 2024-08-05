package com.yoatzin.app.service;

import com.yoatzin.app.model.Comment;

public interface CommentService {
    Comment createComment(Comment comment); // Método para crear un comentario.

    Comment getCommentById(Long id); // Método para obtener un comentario por ID.

    Iterable<Comment> getAllComments(); // Método para obtener todos los comentarios.

    Comment updateComment(Comment newCommentData, Long id); // Método para actualizar un comentario.

    void deleteComment(Long id); // Método para eliminar un comentario.
}
