package ua.light.shop.services.convertors;

import ua.light.shop.entity.Order;
import ua.light.shop.services.dto.OrderDto;

public interface OrderConvertor {
    Order toEntity(OrderDto dto);

    OrderDto toDto(Order entity);
}