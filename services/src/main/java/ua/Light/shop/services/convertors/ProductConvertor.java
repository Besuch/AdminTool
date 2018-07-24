package ua.Light.shop.services.convertors;

import ua.Light.shop.dao.model.Product;
import ua.Light.shop.services.dto.ProductDto;
import ua.Light.shop.services.dto.UserDto;

public interface ProductConvertor {

    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}
