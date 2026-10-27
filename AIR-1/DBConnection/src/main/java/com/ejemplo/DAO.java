package com.ejemplo;

import java.util.List;

public abstract class DAO<T> {
    public abstract void insert(T obj);
    public abstract void update(T obj);
    public abstract void delete(int id);
    public abstract List<T> getAll();
}
