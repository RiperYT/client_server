package com.example.demo.Services;

import java.util.List;

public interface IService<T> {
    public T get(String id);
    public List<T> getAll();
    public boolean add(T dto);
    public boolean edit(T dto);
    public boolean delete(T dto);
}
