package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTests {

    private OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        orderService = new OrderService();
    }

    public static Stream<Arguments> order_requests() {
        return Stream.of(
                Arguments.of("code1", 5, BigDecimal.valueOf(12.3), BigDecimal.valueOf(61.5)), // productCode, amount, unitPrice, TotalPrice
                Arguments.of("code1", 10, BigDecimal.valueOf(15), BigDecimal.valueOf(150)) // productCode, amount, unitPrice, TotalPrice
        );
    }

    @ParameterizedTest
    @MethodSource("order_requests") // method source içinde ne kadar varsa o kadar çalışacak
    public void it_should_create_orders(String productCode, Integer amount, BigDecimal unitPrice, BigDecimal totalPrice){
        // given
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode(productCode)
                .unitPrice(unitPrice)
                .amount(amount)
                .build();

        //when
        OrderDto order = orderService.createOrder(request);

        //then
        then(order.getTotalPrice()).isEqualTo(totalPrice);
    }
}
