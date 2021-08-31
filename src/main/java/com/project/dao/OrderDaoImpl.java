package com.project.dao;

import com.project.model.Order;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl implements OrderDao{
    private Connection connection;
    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }

    @Override
    public Order getById(Integer integer) {
        return null;
    }

    @Override
    public int getByName(String name) {
        return 0;
    }
}
