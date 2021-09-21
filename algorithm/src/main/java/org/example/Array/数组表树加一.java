package org.example.Array;

import java.util.Arrays;

public class 数组表树加一 {
    static int[] plusOne(int[] digits) {
        int v, w = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            v = digits[i] + w;
            if (w > 0) { w--; }
            if (v >= 10) { v -= 10; w++; }
            digits[i] = v;
        }
        if (w > 0) {
            int[] r = new int[digits.length + 1];
            r[0] = w;
            // System.arraycopy(digits, 0, r, 1, r.length - 1);
            return r;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(plusOne(new int[]{9, 9, 9, 9}))
        );
    }
}
