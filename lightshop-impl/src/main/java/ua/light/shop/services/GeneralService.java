package ua.light.shop.services;

import java.util.List;

public interface GeneralService<T> {
    void create(T t);

    void delete(Long id);

    void update(Long id, T t);

    List<T> findAll();

    T findById(Long id);
}