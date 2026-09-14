package com.example.mooshproject.mappers;

import com.example.mooshproject.dtos.CategoryDto;
import com.example.mooshproject.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
    public interface CategoryMapper {
    CategoryDto toDto(Category category);
}

