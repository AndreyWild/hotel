package com.senla.service.impl;

import com.senla.api.service.IOrderService;
import com.senla.dao.impl.OrderDao;
import com.senla.model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;// = new OrderDao();

    @Autowired
    @Transactional
    public Order save(Order entity) {
        return orderDao.save(entity);
    }

    @Autowired
    @Transactional
    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Autowired
    @Transactional
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Autowired
    @Transactional
    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    @Autowired
    @Transactional
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Autowired
    @Transactional
    public void deleteAll() {
        orderDao.deleteAll();
    }

    @Autowired
    @Transactional
    public void update(Order entity) {
        orderDao.update(entity);
    }
}
