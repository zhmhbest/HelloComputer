package org.example.DynamicProgramming;

import org.example.EasyAssert;

/**
 * n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class 约瑟夫问题 {

    static int lastRemaining(int n, int m) {
        if (n == 1) return 0; // 长度为1，返回第一个元素
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }

    static int lastRemaining2(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (m + x) % i;
        }
        return x;
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(3, lastRemaining(5, 3));
        EasyAssert.AssertEqual(3, lastRemaining2(5, 3));
        EasyAssert.AssertEqual(2, lastRemaining(10, 17));
        EasyAssert.AssertEqual(2, lastRemaining2(10, 17));
        System.out.println("OK");
    }

}
