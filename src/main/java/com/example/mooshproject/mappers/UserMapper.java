package com.example.mooshproject.mappers;

import com.example.mooshproject.dtos.RegisterUserRequest;
import com.example.mooshproject.dtos.UpdateUserRequest;
import com.example.mooshproject.dtos.UserDto;
import com.example.mooshproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
