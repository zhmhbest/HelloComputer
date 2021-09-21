package org.example.Array;

import java.util.ArrayList;

public class MyStack<E> extends ArrayList<E> {
    protected int capacity;

    public MyStack() {
        super(64);
        this.capacity = 64;
    }

    public MyStack(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    // public boolean isEmpty() {
    //     return size == 0;
    // }

    public boolean push(E e) {
        if (this.size() >= this.capacity) return false;
        return this.add(e);
    }

    public E pop() {
        int index = this.size() - 1;
        if (index >= 0) return this.remove(index);
        return null;
    }

    public E peek() {
        int index = this.size() - 1;
        if (index >= 0) return this.get(index);
        return null;
    }
}