package com.example.mooshproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
        private UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
        private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
        private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public BigDecimal getTotalPrice(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}

