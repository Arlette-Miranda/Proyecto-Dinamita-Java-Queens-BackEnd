package com.yoatzin.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment { // Renombrado de Comments a Comment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Long id_comment; // Identificador único del comentario

    @Column(name = "comment", length = 280, nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "fk_id_user", nullable = false)
    private User user; // Relación muchos a uno con la entidad User

    // Constructores
    public Comment() {}

    public Comment(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    // Getters y Setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString() método
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [id_comment=");
        builder.append(id_comment);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", user=");
        builder.append(user != null ? user.getId() : "null"); // Muestra el ID del usuario o "null" si es nulo
        builder.append("]");
        return builder.toString();
    }
}
