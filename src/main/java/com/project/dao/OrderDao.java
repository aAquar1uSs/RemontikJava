package com.project.dao;

import com.project.model.Order;

public interface OrderDao extends AbstarctDao<Integer, Order>{
    int getByName(String name);
}
