package com.project.daobd;

import com.project.model.Order;

public interface OrderDao extends AbstarctDao<Integer, Order> {
    int getByName(String name);
}
