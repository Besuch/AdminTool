package ua.light.shop.services.convertors.impl;

import org.springframework.stereotype.Component;
import ua.light.shop.dao.model.Product;
import ua.light.shop.services.convertors.ProductConvertor;
import ua.light.shop.services.dto.ProductDto;

@Component
public class ProductConvertorImpl implements ProductConvertor {
    @Override
    public Product toEntity(ProductDto dto) {
        return new Product(
                dto.getName(),
                dto.getCategory(),
                dto.getColor(),
                dto.getParameter(),
                dto.getCount(),
                dto.getPrice(),
                null);
    }

    @Override
    public ProductDto toDto(Product entity) {
        return new ProductDto(
                entity.getName(),
                entity.getCategory(),
                entity.getColor(),
                entity.getParameter(),
                entity.getCount(),
                entity.getPrice());
    }
}