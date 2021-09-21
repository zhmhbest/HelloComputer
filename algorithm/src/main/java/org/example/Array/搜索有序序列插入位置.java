package org.example.Array;

import org.example.EasyAssert;

public class 搜索有序序列插入位置 {

    /**
     * 二分法（探测左边界）
     */
    static int searchInsert(int[] arr, int target) {
        int l = 0, m, r = arr.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        } return l;
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        EasyAssert.AssertEqual(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        EasyAssert.AssertEqual(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        EasyAssert.AssertEqual(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println("OK");
    }
}
