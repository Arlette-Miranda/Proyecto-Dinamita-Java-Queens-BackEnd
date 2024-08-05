package com.yoatzin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.dto.OrdersDto;
import com.yoatzin.app.model.Orders;
import com.yoatzin.app.service.OrderService;

@RestController
@RequestMapping("/orders-dto")
public class OrdersDtoController {

    @Autowired
    private OrderService orderService;

    // Método para crear una nueva orden.
    @PostMapping
    public ResponseEntity<OrdersDto> createOrder(@RequestBody OrdersDto ordersDto) {
        Orders order = new Orders();
        order.setFk_id_user(ordersDto.getFk_id_user());
        order.setFk_id_card(ordersDto.getFk_id_card());
        order.setFk_id_address(ordersDto.getFk_id_address());
        order.setQuantity(ordersDto.getQuantity());
        order.setDate(ordersDto.getDate());
        Orders createdOrder = orderService.createOrder(order);

        ordersDto.setId_order(createdOrder.getId_order());
        return new ResponseEntity<>(ordersDto, HttpStatus.CREATED);
    }

    // Método para obtener una orden por ID.
    @GetMapping("/{id}")
    public ResponseEntity<OrdersDto> getOrderById(@PathVariable Long id) {
        Orders order = orderService.getOrderById(id);
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setId_order(order.getId_order());
        ordersDto.setFk_id_user(order.getFk_id_user());
        ordersDto.setFk_id_card(order.getFk_id_card());
        ordersDto.setFk_id_address(order.getFk_id_address());
        ordersDto.setQuantity(order.getQuantity());
        ordersDto.setDate(order.getDate());

        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }

    // Método para obtener todas las órdenes.
    @GetMapping
    public ResponseEntity<Iterable<OrdersDto>> getAllOrders() {
        Iterable<Orders> orders = orderService.getAllOrders();
        List<OrdersDto> ordersDtos = new ArrayList<>();

        for (Orders order : orders) {
            OrdersDto ordersDto = new OrdersDto();
            ordersDto.setId_order(order.getId_order());
            ordersDto.setFk_id_user(order.getFk_id_user());
            ordersDto.setFk_id_card(order.getFk_id_card());
            ordersDto.setFk_id_address(order.getFk_id_address());
            ordersDto.setQuantity(order.getQuantity());
            ordersDto.setDate(order.getDate());
            ordersDtos.add(ordersDto);
        }

        return new ResponseEntity<>(ordersDtos, HttpStatus.OK);
    }

    // Método para actualizar una orden existente.
    @PutMapping("/{id}")
    public ResponseEntity<OrdersDto> updateOrder(@RequestBody OrdersDto ordersDto, @PathVariable Long id) {
        Orders newOrderData = new Orders();
        newOrderData.setFk_id_user(ordersDto.getFk_id_user());
        newOrderData.setFk_id_card(ordersDto.getFk_id_card());
        newOrderData.setFk_id_address(ordersDto.getFk_id_address());
        newOrderData.setQuantity(ordersDto.getQuantity());
        newOrderData.setDate(ordersDto.getDate());
        Orders updatedOrder = orderService.updateOrder(newOrderData, id);

        ordersDto.setId_order(updatedOrder.getId_order());
        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
    }

    // Método para eliminar una orden.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
