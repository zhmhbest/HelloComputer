package org.example.Mathematics;

import java.util.ArrayList;
import java.util.Collection;

public class 因数分解 {
    /**
     * 因数分解
     */
    static Collection<Integer> factorization(int n) {
        Collection<Integer> holder = new ArrayList<>();
        int k = 2; // 从最小的素数开始
        while (n > 1) {
            if (0 == n % k) {
                // 可以被分解（此处不自增是因为因数可能会重复）
                holder.add(k);
                n /= k;
            } else if (k * k > n) {
                // n为素数
                holder.add(n);
                break;
            } else {
                // 增加尝试因数的值
                k++;
            }
        }
        return holder;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.printf("%d: %s\n", i, factorization(i));
        }
    }
}
