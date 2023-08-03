package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTests {


    @Test
    public void it_should_create_order(){
        //given
        OrderService service = new OrderService(); // is this given to us
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode("code1")
                .amount(5)
//                .unitPrice(BigDecimal.ONE)
                .unitPrice(BigDecimal.valueOf(12.3))
                .build();


        //when
        OrderDto order = service.createOrder(request);

        //then
        then(order).isNotNull(); // this is an assertion
        // Assert Equal diye de olabiliyormuş ??
        then(order.getTotalPrice()).isEqualTo(BigDecimal.valueOf(61.5));
    }
}
