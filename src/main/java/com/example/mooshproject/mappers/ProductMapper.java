package com.example.mooshproject.mappers;

import com.example.mooshproject.dtos.ProductDto;
import com.example.mooshproject.dtos.UpdateUserRequest;
import com.example.mooshproject.entity.Product;
import com.example.mooshproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    @Mapping(target = "id", ignore = true)
    void update(ProductDto productDto, @MappingTarget Product product);

}