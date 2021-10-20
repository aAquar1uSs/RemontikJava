package com.project.DAO;

import com.project.model.Order;

import java.util.List;

public interface OrderDao extends AbstarctDao<Integer, Order> {
   boolean insertNewOrder(Order order);

   List findUserOrders(int userId);
}
