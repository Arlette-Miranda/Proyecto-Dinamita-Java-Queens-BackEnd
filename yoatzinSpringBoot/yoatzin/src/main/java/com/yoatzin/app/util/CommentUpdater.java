package com.yoatzin.app.util;

import com.yoatzin.app.model.Comment;

public final class CommentsUpdater {

    private CommentsUpdater() {}

    public static Comment updateComment(Comment existingComment, Comment newCommentData) {
        if (existingComment == null || newCommentData == null) {
            throw new IllegalArgumentException("Comment data cannot be null");
        }

        existingComment.setComment(newCommentData.getComment() != null ? newCommentData.getComment() : existingComment.getComment());
        existingComment.setFkIdUser(newCommentData.getFkIdUser() != null ? newCommentData.getFkIdUser() : existingComment.getFkIdUser());

        return existingComment;
    }
}
