package com.exemple.dao;

import java.util.List;

public interface GenericDAO<T,ID> {
    T create(T entity);
    T read(ID id);
    void update(T entity);
    void delete(ID id);

    List<T> readAll();
}
