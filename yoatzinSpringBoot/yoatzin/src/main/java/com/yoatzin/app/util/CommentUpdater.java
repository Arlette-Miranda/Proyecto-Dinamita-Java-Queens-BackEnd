package com.yoatzin.app.util;

import com.yoatzin.app.model.Comment;

public final class CommentUpdater {
    private CommentUpdater() {}

    public static Comment updateComment(Comment existingComment, Comment newCommentData) {
        if (existingComment == null || newCommentData == null) {
            throw new IllegalArgumentException("Comment data cannot be null");
        }

        existingComment.setComment(newCommentData.getComment());
        existingComment.setUser(newCommentData.getUser());

        return existingComment;
    }
}
