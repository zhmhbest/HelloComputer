package org.example.Array;

import java.util.Arrays;

public class 移除指定值的元素 {

    static int removeElement(int[] arr, int val) {
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) continue;
            arr[cur++] = arr[i];
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }
}
