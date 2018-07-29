package ua.Light.shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.Light.shop.dao.model.Product;
import ua.Light.shop.dao.repositories.ProductDao;
import ua.Light.shop.services.ProductService;
import ua.Light.shop.services.convertors.ProductConvertor;
import ua.Light.shop.services.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductConvertor productConvertor;

    public ProductServiceImpl(ProductDao productDao, ProductConvertor productConvertor) {
        this.productDao = productDao;
        this.productConvertor = productConvertor;
    }

    @Override
    @Transactional
    public void create(ProductDto product) {
        Product productEntity = productConvertor.toEntity(product);
        productDao.create(productEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, ProductDto product) {
        Product entity = productConvertor.toEntity(product);
        productDao.update(id, entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> products = productDao.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: products) {
            ProductDto dto = productConvertor.toDto(product);
            productDtos.add(dto);
        }
        return productDtos;
    }

    @Override
    public ProductDto findById(Long id) {
        return productConvertor.toDto(productDao.get(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        productDao.deleteAll();
    }
}
