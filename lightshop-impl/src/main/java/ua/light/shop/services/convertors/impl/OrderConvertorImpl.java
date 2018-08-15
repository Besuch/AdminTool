package ua.light.shop.services.convertors.impl;

import org.springframework.stereotype.Component;
import ua.light.shop.dao.model.Order;
import ua.light.shop.services.convertors.OrderConvertor;
import ua.light.shop.services.dto.OrderDto;

@Component
public class OrderConvertorImpl implements OrderConvertor {
    @Override
    public Order toEntity(OrderDto dto) {
        return new Order(
                dto.getId(),
                dto.getUserId(),
                dto.getProductId(),
                dto.getName(),
                dto.getCount());
    }

    @Override
    public OrderDto toDto(Order entity) {
        return new OrderDto(
                entity.getId(),
                entity.getUserId(),
                entity.getProductId(),
                entity.getName(),
                entity.getCount());
    }
}