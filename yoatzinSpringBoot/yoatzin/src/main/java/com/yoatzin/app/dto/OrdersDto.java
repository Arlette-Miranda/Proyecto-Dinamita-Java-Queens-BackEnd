package com.yoatzin.app.dto;

import java.time.LocalDateTime;

public class OrdersDto {
    private Long id_order;
    private Long fk_id_user;
    private Long fk_id_card;
    private Long fk_id_address;
    private int quantity;
    private LocalDateTime date;

    // Getters y Setters
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
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
}
