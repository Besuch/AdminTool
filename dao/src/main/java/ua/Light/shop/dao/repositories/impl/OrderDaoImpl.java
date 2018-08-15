package ua.Light.shop.dao.repositories.impl;

import org.springframework.stereotype.Repository;
import ua.Light.shop.dao.model.Order;
import ua.Light.shop.dao.model.Product;
import ua.Light.shop.dao.repositories.OrderDao;
import ua.Light.shop.dao.repositories.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order get(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> findAllOrder = entityManager.createQuery("SELECT p FROM Order p", Order.class);
        return findAllOrder.getResultList();
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Order p WHERE p.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    public void update(Long id, Order order) {
        order.setId(id);
        entityManager.merge(order);
    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Order");
        query.executeUpdate();
    }
}
