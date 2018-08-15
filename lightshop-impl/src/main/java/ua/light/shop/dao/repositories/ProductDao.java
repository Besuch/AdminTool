package ua.light.shop.dao.repositories;

import ua.light.shop.dao.model.Product;

import java.util.List;

public interface ProductDao {
    void create(Product product);

    Product get(Long id);

    List<Product> findAll();

    void delete(Long id);

    void update(Long id, Product product);

    void deleteAll();
}