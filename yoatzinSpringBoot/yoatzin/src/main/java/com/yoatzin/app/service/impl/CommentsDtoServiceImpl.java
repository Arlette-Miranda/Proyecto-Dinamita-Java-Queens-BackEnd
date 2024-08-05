package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.CommentsDto;
import com.yoatzin.app.model.Comments;
import com.yoatzin.app.repository.CommentRepository;
import com.yoatzin.app.service.CommentsDtoService;
import com.yoatzin.app.util.CommentsGenerator;
import com.yoatzin.app.util.CommentsUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentsDtoServiceImpl implements CommentsDtoService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentsDto createComment(CommentsDto commentsDto) {
        Comments comment = CommentsGenerator.fromDto(commentsDto);
        Comments createdComment = commentRepository.save(comment);
        commentsDto.setId_comment(createdComment.getId_comment());
        return commentsDto;
    }

    @Override
    public CommentsDto getCommentById(Long id) {
        Optional<Comments> optionalComment = commentRepository.findById(id);
        if (optionalComment.isEmpty()) {
            throw new IllegalStateException("Comment not found with id " + id);
        }
        Comments comment = optionalComment.get();
        return new CommentsDto(comment.getId_comment(), comment.getFk_id_user(), comment.getComment());
    }

    @Override
    public List<CommentsDto> getAllComments() {
        List<Comments> comments = commentRepository.findAll();
        return comments.stream().map(comment -> new CommentsDto(comment.getId_comment(), comment.getFk_id_user(), comment.getComment()))
                .collect(Collectors.toList());
    }

    @Override
    public CommentsDto updateComment(Long id, CommentsDto commentsDto) {
        Comments existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Comment not found with id " + id));
        Comments updatedComment = CommentsUpdater.updateComment(existingComment, commentsDto);
        commentRepository.save(updatedComment);
        return commentsDto;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
