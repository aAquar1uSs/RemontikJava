package com.project.dao.jdbc;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao<T> {
    public void insert(Connection connection,T adr);

    public T getById(int id);

    public void update(T adr);

    public void delete(T adr);

    public ArrayList<T> getAll();
}