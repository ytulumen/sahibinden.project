package com.yasin.service;

import java.util.List;

public interface AbstractService<T> {

    public T getCurrent();
    public List<T> getAll();
    public double converter(boolean flag, String type, double value);
}
