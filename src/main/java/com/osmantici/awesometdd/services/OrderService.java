package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
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
//        return new OrderDto();
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        return OrderDto.builder().totalPrice(totalPrice).build();
    }
}
