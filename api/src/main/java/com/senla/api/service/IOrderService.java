package com.senla.api.service;

import com.senla.api.dao.IOrderDao;
import com.senla.model.entities.Order;

public interface IOrderService extends IGenericService<Order>{

    void setOrderDao(IOrderDao orderDao);
}
