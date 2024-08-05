package com.yoatzin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.dto.CommentsDto;
import com.yoatzin.app.model.Comments;
import com.yoatzin.app.service.CommentService;

@RestController
@RequestMapping("/comments-dto")
public class CommentsDtoController {

    @Autowired
    private CommentService commentService;

    // Método para crear un nuevo comentario.
    @PostMapping
    public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto commentsDto) {
        Comments comment = new Comments();
        comment.setComment(commentsDto.getComment());
        comment.setFk_id_user(commentsDto.getFk_id_user());
        Comments createdComment = commentService.createComment(comment);

        commentsDto.setId_comment(createdComment.getId_comment());
        return new ResponseEntity<>(commentsDto, HttpStatus.CREATED);
    }

    // Método para obtener un comentario por ID.
    @GetMapping("/{id}")
    public ResponseEntity<CommentsDto> getCommentById(@PathVariable Long id) {
        Comments comment = commentService.getCommentById(id);
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setId_comment(comment.getId_comment());
        commentsDto.setFk_id_user(comment.getFk_id_user());
        commentsDto.setComment(comment.getComment());

        return new ResponseEntity<>(commentsDto, HttpStatus.OK);
    }

    // Método para obtener todos los comentarios.
    @GetMapping
    public ResponseEntity<Iterable<CommentsDto>> getAllComments() {
        Iterable<Comments> comments = commentService.getAllComments();
        List<CommentsDto> commentsDtos = new ArrayList<>();

        for (Comments comment : comments) {
            CommentsDto commentsDto = new CommentsDto();
            commentsDto.setId_comment(comment.getId_comment());
            commentsDto.setFk_id_user(comment.getFk_id_user());
            commentsDto.setComment(comment.getComment());
            commentsDtos.add(commentsDto);
        }

        return new ResponseEntity<>(commentsDtos, HttpStatus.OK);
    }

    // Método para actualizar un comentario existente.
    @PutMapping("/{id}")
    public ResponseEntity<CommentsDto> updateComment(@RequestBody CommentsDto commentsDto, @PathVariable Long id) {
        Comments newCommentData = new Comments();
        newCommentData.setComment(commentsDto.getComment());
        newCommentData.setFk_id_user(commentsDto.getFk_id_user());
        Comments updatedComment = commentService.updateComment(newCommentData, id);

        commentsDto.setId_comment(updatedComment.getId_comment());
        return new ResponseEntity<>(commentsDto, HttpStatus.OK);
    }

    // Método para eliminar un comentario.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
