package ua.light.shop.services;

import ua.light.shop.services.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void create(OrderDto order);

    void delete(Long id);

    void update(Long id, OrderDto order);

    List<OrderDto> findAll();

    OrderDto findById(Long id);

    void deleteAll();
}