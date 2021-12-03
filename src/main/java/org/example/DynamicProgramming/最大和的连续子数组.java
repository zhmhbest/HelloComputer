package org.example.DynamicProgramming;

public class 最大和的连续子数组 {

    static int maxSubArray(int[] nums) {
        int mem = nums[0];
        int cur = 0;
        for (int x : nums) {
            cur = Math.max(cur + x, x);     // 增加当前数字是否有增益效果
            mem = Math.max(mem, cur);       // 记忆最大组
        }
        return mem;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
