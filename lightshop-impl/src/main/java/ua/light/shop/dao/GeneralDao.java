package ua.light.shop.dao;

import ua.light.shop.entity.Order;

import java.util.List;

public interface GeneralDao<T> {
    void create(T t);

    T get(Long id);

    List<T> findAll();

    void delete(Long id);

    void update(Long id, T t);
}