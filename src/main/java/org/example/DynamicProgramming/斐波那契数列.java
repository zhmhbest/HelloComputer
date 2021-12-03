package org.example.DynamicProgramming;

public class 斐波那契数列 {

    // F(0) = 0,   F(1) = 1
    // F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

    static int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(5));
    }
}
