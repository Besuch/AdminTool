package ua.Light.shop.services.convertors.impl;

import org.springframework.stereotype.Component;
import ua.Light.shop.dao.model.Order;
import ua.Light.shop.dao.model.Product;
import ua.Light.shop.services.convertors.OrderConvertor;
import ua.Light.shop.services.convertors.ProductConvertor;
import ua.Light.shop.services.dto.OrderDto;
import ua.Light.shop.services.dto.ProductDto;

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
