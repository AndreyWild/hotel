package com.senla.service.impl;

import com.senla.api.dao.IOrderDao;
import com.senla.api.service.IOrderService;
import com.senla.dao.impl.OrderDao;
import com.senla.model.entities.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public Order save(Order entity) {
        return orderDao.save(entity);
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
    public void deleteAll() {
        orderDao.deleteAll();
    }

    @Override
    public void update(Order entity) {
        orderDao.update(entity);
    }
}
