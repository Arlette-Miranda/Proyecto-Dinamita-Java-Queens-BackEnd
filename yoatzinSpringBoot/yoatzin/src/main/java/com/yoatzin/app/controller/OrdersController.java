package com.yoatzin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Orders;
import com.yoatzin.app.service.OrderService;

@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/orders") // Mapea las solicitudes HTTP a /orders.
public class OrdersController {

    @Autowired // Inyección de dependencias de Spring.
    private OrderService orderService;

    // Método para crear una nueva orden.
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED); // Retorna la orden creada con el código HTTP 201.
    }

    // Método para obtener una orden por ID.
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Orders order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK); // Retorna la orden con el código HTTP 200.
    }

    // Método para obtener todas las órdenes.
    @GetMapping
    public ResponseEntity<Iterable<Orders>> getAllOrders() {
        Iterable<Orders> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK); // Retorna todas las órdenes con el código HTTP 200.
    }

    // Método para actualizar una orden existente.
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders newOrderData, @PathVariable Long id) {
        Orders updatedOrder = orderService.updateOrder(newOrderData, id);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK); // Retorna la orden actualizada con el código HTTP 200.
    }

    // Método para eliminar una orden.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna el código HTTP 204 indicando que la orden fue eliminada.
    }
}
