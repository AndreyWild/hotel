package com.senla.service.impl;

import com.senla.api.dao.IOrderDao;
import com.senla.api.service.IOrderService;
import com.senla.model.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {

    private IOrderDao orderDao;

//    @Autowired
//    public OrderService(IOrderDao orderDao) {
//        this.orderDao = orderDao;
//    }

    @Override
    public void save(Order entity) {
        orderDao.save(entity);
    }

    @Override
    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    public void update(Order entity) {
        orderDao.update(entity);
    }
}
