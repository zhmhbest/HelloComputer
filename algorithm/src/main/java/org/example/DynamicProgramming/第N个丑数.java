package org.example.DynamicProgramming;

import org.example.EasyAssert;

public class 第N个丑数 {

    static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n]; dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            // 当前丑数
            int xn = Math.min(Math.min(n2, n3), n5);
            // 更新索引
            if (xn == n2) a++;
            if (xn == n3) b++;
            if (xn == n5) c++;
            // 第i+1个丑数为
            dp[i] = xn;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(12, nthUglyNumber(10));
        EasyAssert.AssertEqual(1536, nthUglyNumber(100));
        System.out.println("OK");
    }
}
