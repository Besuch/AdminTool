package ua.Light.shop.services;

import ua.Light.shop.services.dto.OrderDto;
import ua.Light.shop.services.dto.ProductDto;

import java.util.List;

public interface OrderService {

    void create(OrderDto order);
    void delete(Long id);
    void update(Long id, OrderDto order);
    List<OrderDto> findAll();
    OrderDto findById(Long id);
    void deleteAll();
}
