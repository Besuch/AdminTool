package ua.light.shop.dao;

import java.util.List;

public interface GeneralDao<T> {
    void create(T t);

    T get(Long id);

    List<T> findAll();

    void delete(Long id);

    void update(T t);
}