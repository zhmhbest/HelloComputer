package org.example.Mathematics;

import java.util.ArrayList;
import java.util.Collection;

public class 整数分解 {
    /**
     * 低位在前
     */
    static Collection<Integer> fractureInteger(int num) {
        Collection<Integer> holder = new ArrayList<>();
        if (0 == num) {
            holder.add(0);
        } else {
            while(0 != num) {
                holder.add(num % 10);
                num /= 10;
            }
        }
        return holder;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%d: %s\n", i, fractureInteger(i));
        }
    }
}
