package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTests {


    @Test
    public void it_should_create_order(){
        //given
        OrderService service = new OrderService(); // is this given to us
        CreateOrderRequest request = new CreateOrderRequest();

        //when
        OrderDto order = service.createOrder(request);

        //then
        then(order).isNotNull(); // this is an assertion
        // Assert Equal diye de olabiliyormuş ??
    }
}
