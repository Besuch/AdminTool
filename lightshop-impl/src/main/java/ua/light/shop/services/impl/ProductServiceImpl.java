package ua.light.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.light.shop.dao.GeneralDao;
import ua.light.shop.entity.Product;
import ua.light.shop.dao.ProductDao;
import ua.light.shop.services.ProductService;
import ua.light.shop.services.convertors.ProductConvertor;
import ua.light.shop.services.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductConvertor productConvertor;

    @Autowired
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
        return products.stream().map(productConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return productConvertor.toDto(productDao.get(id));
    }
}