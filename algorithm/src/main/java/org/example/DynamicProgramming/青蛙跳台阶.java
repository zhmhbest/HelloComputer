package org.example.DynamicProgramming;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class 青蛙跳台阶 {

    static int numWays(int n) {
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(numWays(10));
    }

}
