package com.example.mooshproject.payments;

import com.example.mooshproject.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class PaymentResult {
    private Long orderId;
    private OrderStatus paymentStatus;
}
