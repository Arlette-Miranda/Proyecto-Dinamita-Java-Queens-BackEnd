package com.yoatzin.app.util;

import com.yoatzin.app.dto.CommentsDto;
import com.yoatzin.app.model.Comments;

public class CommentsGenerator {
    public static Comments fromDto(CommentsDto commentsDto) {
        Comments comment = new Comments();
        comment.setComment(commentsDto.getComment());
        comment.setFk_id_user(commentsDto.getFk_id_user());
        return comment;
    }
}
