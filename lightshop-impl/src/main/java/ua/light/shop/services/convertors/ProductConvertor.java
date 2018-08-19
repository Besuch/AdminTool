package ua.light.shop.services.convertors;

import ua.light.shop.entity.Product;
import ua.light.shop.services.dto.ProductDto;

public interface ProductConvertor {
    Product toEntity(ProductDto dto);

    ProductDto toDto(Product entity);
}