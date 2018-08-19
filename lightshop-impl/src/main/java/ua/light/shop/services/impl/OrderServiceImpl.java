package ua.light.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.light.shop.dao.GeneralDao;
import ua.light.shop.entity.Order;
import ua.light.shop.dao.OrderDao;
import ua.light.shop.services.OrderService;
import ua.light.shop.services.convertors.OrderConvertor;
import ua.light.shop.services.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final OrderConvertor orderConvertor;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderConvertor orderConvertor) {
        this.orderDao = orderDao;
        this.orderConvertor = orderConvertor;
    }

    @Override
    @Transactional
    public void create(OrderDto order) {
        Order orderEntity = orderConvertor.toEntity(order);
        orderDao.create(orderEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, OrderDto order) {
        Order entity = orderConvertor.toEntity(order);
        orderDao.update(id, entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> orders = orderDao.findAll();
        return orders.stream().map(orderConvertor::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Long id) {
        return orderConvertor.toDto(orderDao.get(id));
    }

}