package com.example.mooshproject.dtos;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class AddItemToCartRequest {
    private Long productId;
}
