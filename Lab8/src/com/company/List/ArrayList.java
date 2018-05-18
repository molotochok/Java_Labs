package com.company.List;

import com.company.TrainHierarchy.Train;

import java.io.Serializable;

public class ArrayList implements List<Train>, Serializable {

    private final int DEFAULT_CAPACITY = 15;
    private int       arrSize;
    private String    description;
    private Train[] arr;

    public ArrayList(){
        ensureCapacity(DEFAULT_CAPACITY);
    }
    public ArrayList(Train element){
        ensureCapacity(DEFAULT_CAPACITY);
        add(element);
    }
    public ArrayList(List<Train> arrayList){
        ensureCapacity(arrayList.size());

        arrSize = arr.length;

        for(int i = 0; i < arrSize;i++){
            arr[i] = arrayList.get(i);
        }
    }

    @Override
    public int size() {
        return arrSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Train o) {
        for(int i = 0; i < size(); i++){
            if(arr[i] == o)
                return true;
        }
        return false;
    }

    @Override
    public boolean add(Train o) {
        add(size(), o);
        return true;
    }

    @Override
    public void clear() {
        arrSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public Train get(int index) {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        return arr[index];
    }

    @Override
    public Train set(int index, Train element) {
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();

        Train item = arr[index];
        arr[index] = item;

        return item;
    }

    @Override
    public void add(int index, Train element) {
        if(arr.length == size())
            ensureCapacity(size() * 1.3f);
        for (int i = size(); i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;

        arrSize++;
    }

    @Override
    public Train remove(int index) {
        Train item = arr[index];

        for(int i = index; i < size() - 1; i++){
            arr[i] = arr[i+1];
        }

        return item;
    }

    @Override
    public int indexOf(Train o) {
        for(int i = 0; i < size();i++){
            if(arr[i] == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void ensureCapacity(float newCapacity) {
        if (newCapacity < arrSize) return;

        Train[] oldItems = arr;

        arr = new Train[(int) newCapacity];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = oldItems[i];
        }
    }

    @Override
    public void output() {
        System.out.println("========= " + description + " =========");
        for(int i = 0;i<size();i++){
            System.out.println(arr[i]);
        }
        System.out.println("===============================");
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Iterator createIterator() {
        return new ArrayListIterator(this);
    }

    @Override
    public String toString() {
        String out = "";

        Iterator iterator = createIterator();
        while(iterator.hasNext()){
            out += iterator.next().toString();
        }
        return out;
    }
}
