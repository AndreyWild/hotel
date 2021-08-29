package com.senla.dao.impl;

import com.senla.api.dao.IOrderDao;
import com.senla.model.entities.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDao extends AbstractDao<Order> implements IOrderDao {
}
