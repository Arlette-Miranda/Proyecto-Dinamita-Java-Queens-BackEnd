package com.yoatzin.app.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "fk_id_user", nullable = false)
    private Long fk_id_user;

    @Column(name = "fk_id_card", nullable = false)
    private Long fk_id_card;

    @Column(name = "fk_id_address", nullable = false)
    private Long fk_id_address;

    // Constructors
    public Orders() {}

    public Orders(int quantity, LocalDateTime date, Long fk_id_user, Long fk_id_card, Long fk_id_address) {
        this.quantity = quantity;
        this.date = date;
        this.fk_id_user = fk_id_user;
        this.fk_id_card = fk_id_card;
        this.fk_id_address = fk_id_address;
    }

    // Getters and Setters
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getFk_id_user() {
        return fk_id_user;
    }

    public void setFk_id_user(Long fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    public Long getFk_id_card() {
        return fk_id_card;
    }

    public void setFk_id_card(Long fk_id_card) {
        this.fk_id_card = fk_id_card;
    }

    public Long getFk_id_address() {
        return fk_id_address;
    }

    public void setFk_id_address(Long fk_id_address) {
        this.fk_id_address = fk_id_address;
    }

    // toString() method
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Orders [id_order=");
        builder.append(id_order);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", date=");
        builder.append(date);
        builder.append(", fk_id_user=");
        builder.append(fk_id_user);
        builder.append(", fk_id_card=");
        builder.append(fk_id_card);
        builder.append(", fk_id_address=");
        builder.append(fk_id_address);
        builder.append("]");
        return builder.toString();
    }
}
