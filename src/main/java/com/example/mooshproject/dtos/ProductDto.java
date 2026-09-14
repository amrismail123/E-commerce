package com.example.mooshproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    public Long id;
    public String name;
    public BigDecimal price;
    public String description;
    public Long categoryId;

}
