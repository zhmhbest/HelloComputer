package org.example.Array;

import java.util.LinkedList;
import java.util.Queue;

public class 队列表栈 {
    static class StackByQueue {
        Queue<Integer> queue;
        public StackByQueue() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            // 全部转到后面
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
