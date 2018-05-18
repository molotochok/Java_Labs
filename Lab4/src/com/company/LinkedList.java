package com.company;

public class LinkedList<T>{
    public class Node<T>{
        private T data;
        private Node<T> next;

        //Constructor
        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        //getters and setters
        public T getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
        public void setData(T data){
            this.data = data;
        }
        public void setNext(Node<T> next){
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    // Constructors
    public LinkedList(){
        head = null;
        tail = null;
    }
    public LinkedList(T data){
        pushBack(data);
    }
    // Public methods
    public int size(){
        int index = 0;

        Node<T> curr = head;
        while(curr != null){
            curr = curr.getNext();
            index++;
        }
        return index;
    }

    public boolean contains(T data){
        Node<T> curr = head;

        while(curr != null){
            if(curr.getData() == data){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public void pushBack(T data){
        Node<T> temp = new Node(data, null);
        if(head == null){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
    }
    public void remove(T data){
        Node<T> temp = head;
        while(temp.getNext() != null){
            if (temp.getNext().getData() == data){
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }
    public void clear(){
        Node<T> temp = head;
        while(temp != null){
            temp.setData(null);
            temp = temp.getNext();
        }
        head = null;
        tail = null;
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        String out = "";
        while(temp != null){
            out += temp.data + " ";
            temp = temp.getNext();
        }
        return out;
    }

    public Node getHead(){
        return head;
    }
}
