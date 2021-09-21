package org.example.Mathematics;

import java.util.*;

public class 素数质数 {
    /**
     * 枚举法
     * 如果一个数是合数，那么它必有一个小于等于其平方根的因数
     */
    static boolean isPrime(int num) {
        for (int k = 2; k * k <= num; k++) {
            if (0 == num % k) return false;
        }
        return true;
    }

    /**
     * 枚举法——统计自然数n以内的素数个数
     */
    static int countPrimesEnum(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    /**
     * 埃氏筛——统计自然数n以内的素数个数
     */
    static int countPrimesEhrlichSieve(int n) {
        boolean[] primeLabels = new boolean[n];
        Arrays.fill(primeLabels, true); // 全部填充为1，即标记为质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primeLabels[i]) {
                count += 1;
                // 如果一个数是质数，那么其倍数一定为合数
                // 如果一个数是合数，那么它一定是一个小于它的质数的倍数
                // 存在重复标记：45会被3和5标记。
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primeLabels[j] = false;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 线性筛——统计自然数n以内的素数个数
     */
    static int countPrimesLinearSieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] primeLabels = new boolean[n];
        Arrays.fill(primeLabels, true);
        for (int i = 2; i < n; i++) {
            if (primeLabels[i]) {
                primes.add(i);
            }
            // 遍历质数表
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                primeLabels[i * primes.get(j)] = false;
                if (0 == i % primes.get(j)) break;
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        System.out.println(countPrimesEnum(100));
        System.out.println(countPrimesEhrlichSieve(100));
        System.out.println(countPrimesLinearSieve(100));
    }
}
