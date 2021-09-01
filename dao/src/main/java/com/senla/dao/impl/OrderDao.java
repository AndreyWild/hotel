package com.senla.dao.impl;

import com.senla.api.dao.IOrderDao;
import com.senla.model.entities.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends AbstractDao<Order> implements IOrderDao {
}
