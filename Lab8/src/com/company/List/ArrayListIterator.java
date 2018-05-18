package com.company.List;

public class ArrayListIterator implements Iterator {

    private ArrayList arrayList;
    private int index;

    public ArrayListIterator(ArrayList arrayList){
        this.arrayList = arrayList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < arrayList.size();
    }

    @Override
    public Object next() {
        Object object = arrayList.get(index);
        index++;
        return object;
    }
}
