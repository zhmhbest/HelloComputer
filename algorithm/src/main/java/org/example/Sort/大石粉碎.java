package org.example.Sort;

import org.example.EasyAssert;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 大石粉碎 {
    static int lastStoneWeight(int[] stones) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(512, (i1, i2) -> i2-i1);
        for (int stone : stones) queue.offer(stone);
        while (queue.size() >= 2) {
            int x = queue.poll();
            int y = queue.poll();
            queue.offer(Math.abs(y - x));
        }
        // System.out.println(queue);
        return queue.poll();
    }

    public static void main(String[] args) {
        EasyAssert.Assert(1 == lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("OK");
    }
}
