package org.example.Mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 和为指定值的正数序列 {

    static int[][] findContinuousSequence(int target) {
        List<int[]> holder = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum < target) {
                r++;
            } else {
                if (sum == target) {
                    // 记录[l, r]内的区间
                    int[] dump = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        dump[i - l] = i;
                    }
                    holder.add(dump);
                }
                l++;
            }
        }
        return holder.toArray(new int[holder.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

}
