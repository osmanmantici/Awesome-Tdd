package com.osmantici.awesometdd.services;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @Data annotation entitylerde problem çıkarabiliyor o yüzden getter setter var
public class CreateOrderRequest {

    private String productCode;

    private Integer amount;

    private BigDecimal unitPrice;
}
