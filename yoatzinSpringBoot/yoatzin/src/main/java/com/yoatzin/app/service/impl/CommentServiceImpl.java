package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Comment;
import com.yoatzin.app.repository.CommentRepository;
import com.yoatzin.app.service.CommentService;

@Service // Indica que esta clase es un servicio de Spring.
public class CommentServiceImpl implements CommentService {
    
    private final CommentRepository commentRepository;

    // Constructor con inyección de dependencias.
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        comment.setId_comment(null); // Asegura que la ID sea generada automáticamente.
        return saveComment(comment); // Guarda el comentario.
    }

    private Comment saveComment(Comment comment) {
        return commentRepository.save(comment); // Método privado para guardar el comentario.
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id); // Busca el comentario por ID.
        if (optionalComment.isEmpty()) {
            throw new IllegalStateException("El comentario no existe con el id " + id); // Lanza excepción si no existe.
        }
        return optionalComment.get(); // Retorna el comentario si existe.
    }

    @Override
    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll(); // Retorna todos los comentarios.
    }

    @Override
    public Comment updateComment(Comment newCommentData, Long id) {
        Comment existingComment = getCommentById(id); // Busca el comentario existente.
        existingComment.setComment(newCommentData.getComment()); // Actualiza los datos del comentario.
        existingComment.setFk_id_user(newCommentData.getFk_id_user());
        return saveComment(existingComment); // Guarda el comentario actualizado.
    }

    @Override
    public void deleteComment(Long id) {
        Comment existingComment = getCommentById(id); // Busca el comentario existente.
        commentRepository.delete(existingComment); // Elimina el comentario.
    }
}

