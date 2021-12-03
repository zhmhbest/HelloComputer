package org.example.Mathematics;

import org.example.EasyAssert;

public class 开根号 {
    /**
     * 二分法
     */
    static int sqrt_2(int x) {
        int l = 0, r = x;
        while (l <= r) {
            int m = (l + r) / 2;
            if ((long) m * m <= x) {
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return l - 1;
    }

    /**
     * 牛顿迭代法
     */
    static int sqrt_n(int x) {
        if (0 == x) return 0;
        double x0 = x;
        for (; ; ) {
            double x1 = 0.5 * (x0 + (double) x / x0);
            if (Math.abs(x0 - x1) < 1e-7) break;
            x0 = x1;
        }
        return (int) x0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i += 1) {
            double dr = Math.sqrt(i);
            int ir = (int) dr;
            System.out.printf("sqrt(%2d) = %.6f | %d\n", i, dr, ir);
            EasyAssert.AssertEqual(ir, sqrt_2(i));
            EasyAssert.AssertEqual(ir, sqrt_n(i));
        }
    }
}
