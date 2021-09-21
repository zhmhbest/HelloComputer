package org.example.Mathematics;

import org.example.EasyAssert;
import org.example.IO;

import java.util.Arrays;

public class 二分查找 {

    /**
     * 二分查找——值
     */
    static int binarySearch(int[] arr, int val, char type) {
        // if (0 == arr.length) return -1;
        int l = 0, r = arr.length - 1; // [l, r]
        while (l <= r) { // 等号保证了单元素区间可以被检索
            int m = (l + r) / 2;
            System.out.printf("\t[%2d, %2d] hit arr[%2d] = %d\n", l, r, m, arr[m]);
            if (arr[m] == val) {
                switch (type) {
                    case 'V':
                        return m;  // 此时直接返回可能在重复元素的任意位置
                    case 'L':
                        r = m - 1; // 探测左边界，收缩右侧
                        break;
                    case 'R':
                        l = m + 1; // 探测右边界，收缩左侧
                        break;
                }
            } else if (arr[m] < val) {
                l = m + 1; // m已经搜索过了
            } else if (arr[m] > val) {
                r = m - 1; // m已经搜索过了
            }
        }
        switch (type) {
            case 'L': return l;     // 左边界：新元素应该插入的位置
            case 'R': return r + 1; // 右边界：新元素应该插入的位置
            default: return -1;     // 命中失败（数字指代字符位置）
        }
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                // {find, targetV, targetL, targetR}, arr
                {{-1, -1, 0, 0}, {}},
                {{3, 1, 1, 2}, {2, 3, 5, 7}},
                {{5, 2, 1, 4}, {1, 5, 5, 5, 9}},
                {{3, -1, 1, 1}, {1, 5, 5, 5, 9}},
                {{7, -1, 4, 4}, {1, 5, 5, 5, 9}},
        };
        for (int[][] row : testCases) {
            int findVal = row[0][0];
            int targetV = row[0][1];
            int targetL = row[0][2];
            int targetR = row[0][3];
            int[] arr = row[1];
            System.out.println("--------------------------------");
            int v = binarySearch(arr, findVal, 'V');
            int l = binarySearch(arr, findVal, 'L');
            int r = binarySearch(arr, findVal, 'R');

            EasyAssert.AssertEqual(v, targetV);
            EasyAssert.AssertEqual(l, targetL);
            EasyAssert.AssertEqual(r, targetR);
            System.out.printf("find %d get (%d, %d, %d) from %s\n",
                    findVal, v, l, r, Arrays.toString(arr));
        }
    }

}
