package ua.light.shop.dao.repositories;

import ua.light.shop.dao.model.Order;

import java.util.List;

public interface OrderDao {
    void create(Order order);

    Order get(Long id);

    List<Order> findAll();

    void delete(Long id);

    void update(Long id, Order order);

    void deleteAll();
}