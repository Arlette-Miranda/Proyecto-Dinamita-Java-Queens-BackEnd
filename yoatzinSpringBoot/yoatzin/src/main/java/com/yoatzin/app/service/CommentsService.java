package com.yoatzin.app.service;

import com.yoatzin.app.model.Comments;

public interface CommentService {
    Comments createComment(Comments comment); // Método para crear un comentario.

    Comments getCommentById(Long id); // Método para obtener un comentario por ID.

    Iterable<Comments> getAllComments(); // Método para obtener todos los comentarios.

    Comments updateComment(Comments newCommentData, Long id); // Método para actualizar un comentario.

    void deleteComment(Long id); // Método para eliminar un comentario.
}
