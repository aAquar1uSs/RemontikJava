package com.project.db.Dao;

public interface Dao<T> {
    public void add(T object);
    public void delete(T object);
}
