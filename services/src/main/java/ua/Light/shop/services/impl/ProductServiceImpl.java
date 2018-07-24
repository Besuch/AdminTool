package ua.Light.shop.services.impl;

import org.springframework.stereotype.Service;
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
    public void create(ProductDto product) {
        Product productEntity = productConvertor.toEntity(product);
        productDao.create(productEntity);

    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productDao.getAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products){
            ProductDto dto = productConvertor.toDto(product);
            productDtos.add(dto);
        }
        return productDtos;
    }
}
