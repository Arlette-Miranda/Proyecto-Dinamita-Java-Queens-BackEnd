package com.yoatzin.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order { // Renombrado de Orders a Order
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id_order; // Identificador único de la orden

    @Column(nullable = false)
    private Integer quantity; // Cantidad de productos en la orden

    @Column(nullable = false)
    private LocalDateTime date; // Fecha de la orden

    @ManyToOne
    @JoinColumn(name = "fk_id_user", nullable = false)
    private User user; // Relación muchos a uno con la entidad User

    @ManyToOne
    @JoinColumn(name = "fk_id_card", nullable = false)
    private Card card; // Relación muchos a uno con la entidad Card

    @ManyToOne
    @JoinColumn(name = "fk_id_address", nullable = false)
    private Address address; // Relación muchos a uno con la entidad Address

    // Constructores
    public Order() {}

    public Order(Integer quantity, LocalDateTime date, User user, Card card, Address address) {
        this.quantity = quantity;
        this.date = date;
        this.user = user;
        this.card = card;
        this.address = address;
    }

    // Getters y Setters
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // toString() método
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [id_order=");
        builder.append(id_order);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", date=");
        builder.append(date);
        builder.append(", user=");
        builder.append(user != null ? user.getId() : "null"); // Muestra el ID del usuario o "null" si es nulo
        builder.append(", card=");
        builder.append(card != null ? card.getId() : "null"); // Muestra el ID de la tarjeta o "null" si es nulo
        builder.append(", address=");
        builder.append(address != null ? address.getId() : "null"); // Muestra el ID de la dirección o "null" si es nulo
        builder.append("]");
        return builder.toString();
    }
}
