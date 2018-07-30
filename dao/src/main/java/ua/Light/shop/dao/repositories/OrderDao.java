package ua.Light.shop.dao.repositories;

import ua.Light.shop.dao.model.Order;
import ua.Light.shop.dao.model.Product;

import java.util.List;

public interface OrderDao {

    void create(Order order);
    Order get(Long id);
    List<Order> findAll();
    void delete(Long id);
    void update(Long id, Order order);
    void deleteAll();

}
