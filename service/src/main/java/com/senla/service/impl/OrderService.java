package com.senla.service.impl;

import com.senla.api.dao.IOrderDao;
import com.senla.api.service.IOrderService;
import com.senla.dao.impl.OrderDao;
import com.senla.model.entities.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    @Setter
    @Getter
    private IOrderDao orderDao;// = new OrderDao();

    @Override
    @Transactional
    public Order save(Order entity) {
        return orderDao.save(entity);
    }

    @Override
    @Transactional
    public Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Override
    @Transactional
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    @Transactional
    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        orderDao.deleteAll();
    }

    @Override
    @Transactional
    public void update(Order entity) {
        orderDao.update(entity);
    }
}
