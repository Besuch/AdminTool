package ua.light.shop.services.convertors;

import ua.light.shop.entity.User;
import ua.light.shop.services.dto.UserDto;

public interface UserConvertor {
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}