package ua.light.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ua.light.shop.entity.User;
import ua.light.shop.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {

        TypedQuery<User> findAllUsers = entityManager.createQuery("SELECT u FROM User u", User.class);
        return findAllUsers.getResultList();
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }
}