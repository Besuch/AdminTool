package ua.light.shop.services;

import ua.light.shop.services.dto.UserDto;

import java.util.List;

public interface UserService {
    void create(UserDto user);

    void delete(Long id);

    void update(Long id, UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);
}