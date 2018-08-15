package ua.light.shop.dao.repositories;

import ua.light.shop.dao.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    User get(Long id);

    List<User> findAll();

    void delete(Long id);

    void update(Long id, User user);
}