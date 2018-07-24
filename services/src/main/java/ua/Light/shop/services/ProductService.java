package ua.Light.shop.services;

import ua.Light.shop.services.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void create(ProductDto product);
    List<ProductDto> getAll();
}
