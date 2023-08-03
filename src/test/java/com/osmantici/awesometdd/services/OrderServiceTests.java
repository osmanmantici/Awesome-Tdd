package com.osmantici.awesometdd.services;

import com.osmantici.awesometdd.dtos.OrderDto;
import com.osmantici.awesometdd.models.Order;
import com.osmantici.awesometdd.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTests {

    // InjectMocks dediğimizde OrderService içerisinde ne kadar Dependency Injection varsa ve onlar hemen aşağıda @Mock ile verilmişse kendi injection'unu yapıyor.
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;


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

    @ParameterizedTest
    @MethodSource("order_requests") // method source içinde ne kadar varsa o kadar çalışacak
    public void it_should_create_orders_and_save(String productCode, Integer amount, BigDecimal unitPrice, BigDecimal totalPrice){
        // given
        CreateOrderRequest request = CreateOrderRequest.builder()
                .productCode(productCode)
                .unitPrice(unitPrice)
                .amount(amount)
                .build();

        Order order = new Order();

        when(orderRepository.save(any())).thenReturn(order); // order repository'de save()'i herhangi bir şey ile çağırdığında order dönecek diyoruz

        //when
        OrderDto orderDto = orderService.createOrder(request);

        //then
        then(orderDto.getTotalPrice()).isEqualTo(totalPrice);
    }

    @Test
    public void it_should_fail_order_creation_when_payment_failed(){

    }
}
