package org.example.Array;

import java.util.Arrays;

public class 删除重复项 {

    /**
     * 探测移动
     */
    // static int removeDuplicates(int[] arr) {
    //     int length = arr.length;
    //     for (int i = 0; i < length; i++) {
    //         // 探测长度
    //         int num = 0;
    //         for (int j = i + 1; j < length; j++) {
    //             if (arr[i] == arr[j]) { num++; } else { break; }
    //         }
    //         // 移动
    //         if (num > 0) {
    //             length -= num;
    //             for (int j = i + 1; j < length; j++) {
    //                 arr[j] = arr[j + num];
    //             }
    //         }
    //     }
    //     return length;
    // }

    static int removeDuplicates(int[] arr) {
        int cur = 0; // 存储位置
        for (int i = 0; i < arr.length;) {
            // 探测长度
            int num = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) { num++; } else { break; }
            }
            arr[cur++] = arr[i];
            i += num;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
