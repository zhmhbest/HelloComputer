package org.example.DynamicProgramming;

import org.example.EasyAssert;

public class 最长上升子序列 {

    static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(3, lengthOfLIS(new int[]{1, 5, 2, 4, 3}));
        EasyAssert.AssertEqual(4, lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // 0 2 3
        // 0 1 2 3
        EasyAssert.AssertEqual(4, lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        EasyAssert.AssertEqual(1, lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        EasyAssert.AssertEqual(2, lengthOfLIS(new int[]{7, 9, 7, 9}));
        EasyAssert.AssertEqual(3, lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        EasyAssert.AssertEqual(6, lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println("OK");
    }
}
