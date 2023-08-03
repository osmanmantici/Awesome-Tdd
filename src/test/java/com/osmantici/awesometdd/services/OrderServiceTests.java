package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class OrderServiceTests {


    @Test
    public void it_should_create_order(){
        //given

        //when
        OrderService service = new OrderService();
        OrderDto order = service.createOrder();

        //then
        then(order).isNotNull(); // this is an assertion
    }
}
