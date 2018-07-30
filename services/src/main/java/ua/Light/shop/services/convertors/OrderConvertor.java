package ua.Light.shop.services.convertors;

import ua.Light.shop.dao.model.Order;
import ua.Light.shop.services.dto.OrderDto;

public interface OrderConvertor {

    Order toEntity(OrderDto dto);
    OrderDto toDto(Order entity);
}
