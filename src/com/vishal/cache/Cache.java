package com.vishal.cache;

public interface Cache<T> {

    T get(T key);
    void put(T key, T value);
}
