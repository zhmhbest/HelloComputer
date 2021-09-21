package org.example.Array;

import java.util.Arrays;

public class CircularQueue<E> {
    protected int f;
    protected int r;
    protected int bufferSize;
    protected E[] bufferData;

    public CircularQueue() {
        this(64);
    }

    public CircularQueue(int size) {
        size++; // 存在一个哨兵单元（用来判断队满）
        this.bufferSize = size;
        this.bufferData = (E[]) new Object[size];
        this.f = 0;
        this.r = 0;
    }

    private int nextIndex(int index) {
        return (index + 1) % this.bufferSize;
    }

    public boolean isEmpty() {
        return this.f == this.r;
    }

    public boolean isFull() {
        return this.f == this.nextIndex(this.r);
    }

    public int size() {
        return (this.r - this.f + this.bufferSize) % this.bufferSize;
    }

    public boolean offer(E val) {
        int r = this.nextIndex(this.r);
        if (this.f == r) return false;
        this.bufferData[this.r] = val;
        this.r = r;
        return true;
    }

    public E poll() {
        if (this.f == this.r) return null;
        E v = this.bufferData[this.f];
        this.f = this.nextIndex(this.f);
        return v;
    }

    public E peek() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException();
        return this.bufferData[this.f];
    }

    public String toString() {
        return Arrays.toString(this.bufferData);
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(3);
        System.out.println(queue.offer(10));
        System.out.println(queue.offer(20));
        System.out.println(queue.offer(30));
        System.out.println(queue.offer(40));
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.offer(66));
        System.out.println(queue.offer(77));
        System.out.println(queue.offer(88));
        System.out.println(queue.offer(99));
        System.out.println(queue);
    }
}
