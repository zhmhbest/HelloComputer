package org.example.Mathematics;

public class 丑数 {
    /**
     * 丑数：1 或 因子仅含2、3、5的整数
     * 前20个为
     *      1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 32, 36
     */
    static boolean isUglyNumber(int num) {
        final int[] primes = {2, 3, 5};
        for (int prime : primes) {
            while (0 == num % prime) {
                num /= prime;
            }
        }
        return 1 == num;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            System.out.printf("%2d %c\n", i, isUglyNumber(i) ? '√' : '×');
        }
    }
}
