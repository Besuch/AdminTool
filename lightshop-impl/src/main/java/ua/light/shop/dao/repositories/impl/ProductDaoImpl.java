package ua.light.shop.dao.repositories.impl;

import org.springframework.stereotype.Repository;
import ua.light.shop.dao.model.Product;
import ua.light.shop.dao.repositories.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product get(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> findAllProducts = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return findAllProducts.getResultList();
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Product p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Product product) {
        product.setId(id);
        entityManager.merge(product);
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Product");
        query.executeUpdate();
    }
}