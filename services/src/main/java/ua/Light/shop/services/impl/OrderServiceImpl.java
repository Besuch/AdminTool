package ua.Light.shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.Light.shop.dao.model.Order;
import ua.Light.shop.dao.repositories.OrderDao;
import ua.Light.shop.services.OrderService;
import ua.Light.shop.services.convertors.OrderConvertor;
import ua.Light.shop.services.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final OrderConvertor orderConvertor;

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
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order: orders) {
            OrderDto dto = orderConvertor.toDto(order);
            orderDtos.add(dto);
        }
        return orderDtos;
    }

    @Override
    public OrderDto findById(Long id) {
        return orderConvertor.toDto(orderDao.get(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        orderDao.deleteAll();
    }
}
