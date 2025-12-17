package com.expensetracker.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.expensetracker.backend.dto.UserDto;
import com.expensetracker.backend.entities.User;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);
    @Mapping(target = "passwort", ignore = true)
    User toEntity(UserDto userDto);
}
