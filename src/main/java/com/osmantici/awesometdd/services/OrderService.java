package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;

import java.math.BigDecimal;

public class OrderService {

    public OrderDto createOrder(CreateOrderRequest request) {
//        return new OrderDto();
        BigDecimal totalPrice = request.getUnitPrice().multiply(BigDecimal.valueOf(request.getAmount()));
        return OrderDto.builder().totalPrice(totalPrice).build();
    }
}
