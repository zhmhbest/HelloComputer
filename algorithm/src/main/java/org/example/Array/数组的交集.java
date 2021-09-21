package org.example.Array;

import java.util.*;

public class 数组的交集 {
    static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> holder = new LinkedList<>();
        for (int num : arr1) set1.add(num);
        for (int num : arr2) set2.add(num);
        for (int num : set1) {
            if (set2.contains(num)) {
                holder.add(num);
            }
        }
        // 封装返回
        int[] buffer = new int[holder.size()];
        for (int i = 0; i < holder.size(); i++) buffer[i] = holder.get(i);
        return buffer;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
