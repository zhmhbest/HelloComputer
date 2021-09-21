package org.example.Sort;

import java.util.Arrays;

public class 最小的k个数 {
    static void swapValue(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void arrayAdjust(int[] arr, int L, int R) {
        int p = R;
        int l = L;
        int r = R - 1;
        for (; ; ) {
            while (l < r && arr[l] <= arr[p]) l++;
            while (l < r && arr[r] >= arr[p]) r--;
            if (l != r) {
                swapValue(arr, l, r);
            } else {
                if (arr[p] >= arr[l]) {
                    l = p;
                } else {
                    swapValue(arr, l, p);
                }
                break;
            }
        }
        if (L < (l - 1)) arrayAdjust(arr, L, l - 1);
        if ((l + 1) < R) arrayAdjust(arr, l + 1, R);
    }

    static void headAdjust(int[] arr, int len, int i) {
        int j = i;
        int p = 2 * i + 1;
        if (p < len && arr[p] > arr[j]) j = p;
        p++;
        if (p < len && arr[p] > arr[j]) j = p;
        if (i != j) {
            swapValue(arr, i, j);
            headAdjust(arr, len, j);
        }
    }

    static void heapSelectSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            headAdjust(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            swapValue(arr, i, 0);
            headAdjust(arr, i, 0);
        }
    }

    static int[] getKLeastNumbers1(int[] arr, int k) {
        if (arr.length > 1) arrayAdjust(arr, 0, arr.length - 1);
        int[] buf = new int[k];
        for (int i = 0; i < k; i++) buf[i] = arr[i];
        return buf;
    }

    static int[] getKLeastNumbers2(int[] arr, int k) {
        heapSelectSort(arr);
        int[] buf = new int[k];
        for (int i = 0; i < k; i++) buf[i] = arr[i];
        return buf;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(Arrays.toString(getKLeastNumbers1(arr, 5)));
        System.out.println(Arrays.toString(getKLeastNumbers2(arr, 5)));
    }
}
