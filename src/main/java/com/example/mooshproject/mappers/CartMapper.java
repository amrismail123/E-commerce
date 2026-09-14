package com.example.mooshproject.mappers;

import com.example.mooshproject.dtos.CartDto;
import com.example.mooshproject.dtos.CartItemDto;
import com.example.mooshproject.dtos.CartProductDto;
import com.example.mooshproject.entity.Cart;
import com.example.mooshproject.entity.CartItem;
import com.example.mooshproject.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "items",source = "items")
    @Mapping(target="totalPrice",expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    CartProductDto map(Product product);
}
