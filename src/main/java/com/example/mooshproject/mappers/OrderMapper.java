package com.example.mooshproject.mappers;

import com.example.mooshproject.dtos.OrderDto;
import com.example.mooshproject.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}
