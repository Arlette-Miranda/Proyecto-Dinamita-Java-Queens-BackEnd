package com.yoatzin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Comments;
import com.yoatzin.app.service.CommentService;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/comments") // Mapea las solicitudes HTTP a /comments.
public class CommentsController {

    @Autowired // Inyección de dependencias de Spring.
    private CommentService commentService;

    // Método para crear un nuevo comentario.
    @PostMapping
    public ResponseEntity<Comments> createComment(@RequestBody Comments comment) {
        Comments createdComment = commentService.createComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED); // Retorna el comentario creado con el código HTTP 201.
    }

    // Método para obtener un comentario por ID.
    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long id) {
        Comments comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK); // Retorna el comentario con el código HTTP 200.
    }

    // Método para obtener todos los comentarios.
    @GetMapping
    public ResponseEntity<Iterable<Comments>> getAllComments() {
        Iterable<Comments> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK); // Retorna todos los comentarios con el código HTTP 200.
    }

    // Método para actualizar un comentario existente.
    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComment(@RequestBody Comments newCommentData, @PathVariable Long id) {
        Comments updatedComment = commentService.updateComment(newCommentData, id);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK); // Retorna el comentario actualizado con el código HTTP 200.
    }

    // Método para eliminar un comentario.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna el código HTTP 204 indicando que el comentario fue eliminado.
    }
}
