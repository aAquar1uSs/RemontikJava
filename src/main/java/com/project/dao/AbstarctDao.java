package com.project.dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @param <K>
 *          Key of the database table
 * @param <E>
 *          Entity in the database table
 */

public interface AbstarctDao<K,E> {

    List<E> getAll();

    boolean update(E entity);

    boolean delete(K k);

    boolean create(E entity);

    E getById(K k);

}
