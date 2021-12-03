package org.example.Array;

import java.util.Arrays;

public class 奇数位于偶数前面 {
    static int[] exchange(int[] nums) {
        if (0 == nums.length) return nums;
        int l = 0;
        int r = nums.length - 1;
        for (; ; ) {
            while (l < r && (1 == nums[l] % 2)) l++;
            while (l < r && (0 == nums[r] % 2)) r--;

            if (l == r) break;
            // System.out.printf("%d-%d", l, r);

            int dump = nums[l];
            nums[l] = nums[r];
            nums[r] = dump;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{})));
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4, 5})));
    }
}
