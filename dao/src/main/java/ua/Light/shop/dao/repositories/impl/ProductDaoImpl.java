package ua.Light.shop.dao.repositories.impl;

import org.springframework.stereotype.Repository;
import ua.Light.shop.dao.model.Product;
import ua.Light.shop.dao.repositories.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

     private final Map<Long,Product> productsMap = new HashMap<>();
     private static long idGenerator = 1L;


    @Override
    public void create(Product product) {
        product.setId(idGenerator++);
        productsMap.put(product.getId(),product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productsMap.values());
    }

    public Map<Long, Product> getProductsMap(){
        return productsMap;
    }
}
