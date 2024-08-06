package com.yoatzin.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comment;

    @Column(name = "comment", length = 280, nullable = false)
    private String comment;

    @Column(name = "fk_id_user", nullable = false)
    private Long fk_id_user;

    // Constructors
    public Comments() {}

    public Comments(String comment, Long fk_id_user) {
        this.comment = comment;
        this.fk_id_user = fk_id_user;
    }

    // Getters and Setters
    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getFk_id_user() {
        return fk_id_user;
    }

    public void setFk_id_user(Long fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    // toString() method
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comments [id_comment=");
        builder.append(id_comment);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", fk_id_user=");
        builder.append(fk_id_user);
        builder.append("]");
        return builder.toString();
    }
}

