package com.yoatzin.app.util;

import com.yoatzin.app.dto.CommentsDto;
import com.yoatzin.app.model.Comments;

public class CommentsUpdater {
    public static Comments updateComment(Comments existingComment, CommentsDto newCommentData) {
        existingComment.setComment(newCommentData.getComment());
        existingComment.setFk_id_user(newCommentData.getFk_id_user());
        return existingComment;
    }
}
