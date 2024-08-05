package com.yoatzin.app.util;

import com.yoatzin.app.model.Comment;

public class CommentUpdater {
    public static Comment updateComment(Comment existingComment, Comment newCommentData) {
        existingComment.setComment(newCommentData.getComment());
        existingComment.setFk_id_user(newCommentData.getFk_id_user());
        return existingComment;
    }
}
