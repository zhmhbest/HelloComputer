package org.example.Array;

import java.util.Arrays;

public class 合并两个有序数组 {
    // static int[] merge(int[] arr1, int[] arr2) {
    //     int m = arr1.length;
    //     int n = arr2.length;
    //     int[] buff = new int[m + n];
    //     int i = 0, j = 0, k = 0;
    //     for (; ; ) {
    //         int door = (i < m ? 1 : 0) + (j < n ? 2 : 0);
    //         switch ( door ) {
    //             case 0:
    //                 return buff;
    //             case 1:
    //                 buff[k++] = arr1[i++];
    //                 break;
    //             case 2:
    //                 buff[k++] = arr2[j++];
    //                 break;
    //             case 3:
    //                 if(arr1[i]<arr2[j]) {
    //                     buff[k++] = arr1[i++];
    //                 } else {
    //                     buff[k++] = arr2[j++];
    //                 }
    //                 break;
    //         }
    //     }
    // }

    static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        int[] buff = arr1;
        for (; ; ) {
            switch ((i >= 0 ? 1 : 0) + (j >= 0 ? 2 : 0)) {
                case 0:
                    return;
                case 1:
                    buff[k--] = arr1[i--];
                    break;
                case 2:
                    buff[k--] = arr2[j--];
                    break;
                case 3:
                    if (arr1[i] > arr2[j]) {
                        buff[k--] = arr1[i--];
                    } else {
                        buff[k--] = arr2[j--];
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // arr1也是缓冲区
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] arr2 = new int[]{2, 5, 6};
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}
