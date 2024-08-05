package com.yoatzin.app.service;

import com.yoatzin.app.dto.CommentsDto;
import com.yoatzin.app.model.Comments;

import java.util.List;

public interface CommentsDtoService {
    CommentsDto createComment(CommentsDto commentsDto);
    CommentsDto getCommentById(Long id);
    List<CommentsDto> getAllComments();
    CommentsDto updateComment(Long id, CommentsDto commentsDto);
    void deleteComment(Long id);
}
