package ua.Light.shop.services.convertors.impl;

import org.springframework.stereotype.Component;
import ua.Light.shop.dao.model.User;
import ua.Light.shop.services.convertors.UserConvertor;
import ua.Light.shop.services.dto.UserDto;

@Component
public class UserConvertorImpl implements UserConvertor {

    public User toEntity(UserDto dto) {
        return new User(
                null,
                dto.getFirstname(),
                dto.getLastname(),
                dto.getAge()
        );

    }

    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getFirstname(),
                entity.getLastname(),
                entity.getAge());
    }
}
