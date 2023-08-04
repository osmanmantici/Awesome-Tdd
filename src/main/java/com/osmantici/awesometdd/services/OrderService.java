package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.clients.PaymentClient;
import com.osmantici.awesometdd.dtos.OrderDto;
import com.osmantici.awesometdd.models.Order;
import com.osmantici.awesometdd.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;

    public OrderService(OrderRepository orderRepository, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
    }

    public OrderDto createOrder(CreateOrderRequest request) {
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        Order order = Order.builder()
                .totalPrice(totalPrice)
                .build();
        this.paymentClient.pay(order);
        Order save = this.orderRepository.save(order);
        return OrderDto.builder()
                .totalPrice(totalPrice)
                .id(save.getId())
                .build();
    }
}
