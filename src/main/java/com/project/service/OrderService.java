package com.project.service;

import com.project.daobd.OrderDao;
import com.project.daobd.OrderDaoImpl;
import com.project.model.Order;

import java.sql.Date;

public class OrderService {

    OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDaoImpl();
    }


    public void insertNewOrder(Order order) {
        orderDao.insertNewOrder(order);
    }

    public Order setNewOrder(String describe, int idUser, Date date) {
        Order order = new Order();
        order.setOrderName(describe);
        order.setOrderPrice(0.00);
        order.setOrderDate(date);
        order.setOrderStatus("Waiting for paid");
        order.setPaymantStatus("Waiting for paid");
        order.setUserid(idUser);
        return order;
    }


}
