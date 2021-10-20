package com.project.service;

import com.project.DAO.OrderDao;
import com.project.DAO.daoImpl.OrderDaoImpl;
import com.project.model.Order;

import java.sql.Date;
import java.util.List;

public class OrderService {

    OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDaoImpl();
    }


    public void insertNewOrder(Order order) {
        orderDao.insertNewOrder(order);
    }

    public List<Order> findAllOrders() {
        return orderDao.getAll();
    }

    public List<Order> findUserOrders(int id) {
        return orderDao.findUserOrders(id);
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
