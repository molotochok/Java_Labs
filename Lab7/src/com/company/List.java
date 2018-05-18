package com.company;

import com.company.Exceptions.ArrayIndexOutOfBoundsException;

public interface List<T>{
    int     size();
    boolean isEmpty();
    boolean contains(T o);
    boolean add(T o);
    void    clear();
    T       get(int index) throws ArrayIndexOutOfBoundsException;
    void    add(int index, T element);
    int     indexOf(T o);
    void    ensureCapacity(float newCapacity);
    void    output();
    void    setDescription(String description);
    String  getDescription();
}
