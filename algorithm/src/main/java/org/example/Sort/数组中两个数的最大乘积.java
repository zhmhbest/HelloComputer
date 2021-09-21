package org.example.Sort;

import java.util.PriorityQueue;

public class 数组中两个数的最大乘积 {
    static int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for (int num : nums) queue.offer(num);
        return queue.poll() * queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 4, 5, 2}));
    }
}
