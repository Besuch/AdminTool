package ua.Light.shop.services.convertors;

import ua.Light.shop.dao.model.User;
import ua.Light.shop.services.dto.UserDto;

public interface UserConvertor {

    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
