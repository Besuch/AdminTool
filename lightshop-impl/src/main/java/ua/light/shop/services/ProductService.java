package ua.light.shop.services;

import ua.light.shop.services.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void create(ProductDto product);

    void delete(Long id);

    void update(Long id, ProductDto product);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void deleteAll();
}