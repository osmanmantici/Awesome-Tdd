package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import com.osmantici.awesometdd.models.Order;
import com.osmantici.awesometdd.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrder(CreateOrderRequest request) {
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        Order order = Order.builder()
                .totalPrice(totalPrice)
                .build();
        Order save = this.orderRepository.save(order);
        return OrderDto.builder()
                .totalPrice(totalPrice)
                .id(save.getId())
                .build();
    }
}
