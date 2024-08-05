package com.yoatzin.app.dto;

public class CommentsDto {
    private Long id_comment;
    private Long fk_id_user;
    private String comment;

    // Getters y Setters
    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
    }

    public Long getFk_id_user() {
        return fk_id_user;
    }

    public void setFk_id_user(Long fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
