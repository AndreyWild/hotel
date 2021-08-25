package com.senla.service.impl;

import com.senla.api.service.IOrderService;
import com.senla.dao.impl.OrderDao;
import com.senla.model.entityes.Order;

import java.util.List;

public class OrderService implements IOrderService {

    //@Autowired
    private final OrderDao orderDao = new OrderDao();

    public Order save(Order entity) {
        return orderDao.save(entity);
    }

    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    public void deleteAll() {
        orderDao.deleteAll();
    }

    public void update(Order entity) {
        orderDao.update(entity);
    }
}
