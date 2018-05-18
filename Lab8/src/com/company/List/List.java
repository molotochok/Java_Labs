package com.company.List;

public interface List<T>{
    int     size();
    boolean isEmpty();
    boolean contains(T o);
    boolean add(T o);
    void    clear();
    T       get(int index);
    T       set(int index, T element);
    void    add(int index, T element);
    T       remove(int index);
    int     indexOf(T o);
    void    ensureCapacity(float newCapacity);
    void    output();
    void    setDescription(String description);
    String  getDescription();
    Iterator createIterator();
}
