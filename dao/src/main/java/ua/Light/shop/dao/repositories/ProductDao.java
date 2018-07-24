package ua.Light.shop.dao.repositories;

import ua.Light.shop.dao.model.Product;

import java.util.List;

public interface ProductDao {

    void create(Product product);
    List<Product> getAll();

}
