package org.example.Array;

/**
 * [0, n]中只有一个数字不存在，找到它
 */
public class 缺失的数字 {

    static int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == m) {
                // 该数字左侧（序号==值）
                l = m + 1;
            } else {
                // 该数字右侧（序号!=值）
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
