package org.example.Sort;

import org.example.EasyAssert;
import java.util.PriorityQueue;

public class 数据中排序后的第K个元素 {
    static class KthLargest {
        PriorityQueue<Integer> queue; // 默认升序
        int k;

        public KthLargest(int k, int[] nums) {
            this.queue = new PriorityQueue<>();
            this.k = k;
            for (int num : nums) add(num);
        }

        public int add(int val) {
            queue.offer(val);
            // 保证队列中有K个元素，则队头为第K最小值
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});
        EasyAssert.Assert(4 == kth.add(3));
        EasyAssert.Assert(5 == kth.add(5));
        EasyAssert.Assert(5 == kth.add(10));
        EasyAssert.Assert(8 == kth.add(9));
        EasyAssert.Assert(8 == kth.add(4));
        System.out.println("OK");
    }
}
