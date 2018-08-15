package ua.light.shop.services.convertors.impl;

import org.springframework.stereotype.Component;
import ua.light.shop.dao.model.User;
import ua.light.shop.services.convertors.UserConvertor;
import ua.light.shop.services.dto.UserDto;

@Component
public class UserConvertorImpl implements UserConvertor {
    public User toEntity(UserDto dto) {
        return new User(
                null,
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge());
    }

    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge());
    }
}