package org.example.Array;

public class 双栈表队列 {
    static class QueueByStack {
        MyStack<Integer> stack1;
        MyStack<Integer> stack2;
        final int eachStackSize = 10;

        public QueueByStack() {
            this.stack1 = new MyStack<>(eachStackSize);
            this.stack2 = new MyStack<>(eachStackSize);
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        public void push(int value) {
            assert (eachStackSize != stack1.size());
            stack1.add(value);
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.peek();
            }
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }

    public static void main(String[] args) {

    }
}
