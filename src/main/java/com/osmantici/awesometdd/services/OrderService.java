package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;

import java.math.BigDecimal;

public class OrderService {

    public OrderDto createOrder(CreateOrderRequest request) {
//        return new OrderDto();
        return OrderDto.builder().totalPrice(BigDecimal.valueOf(61.5)).build();
    }
}
