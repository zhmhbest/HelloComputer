package org.example.Array;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> xStack = new Stack<>();
    private final Stack<Integer> mStack = new Stack<>();

    public MinStack() {
        mStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        mStack.push(Math.min(mStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        mStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(123);
        stack.push(456);
        System.out.println(stack.getMin());
    }
}
