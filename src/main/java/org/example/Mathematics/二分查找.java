package org.example.Mathematics;

import org.example.EasyAssert;

import java.util.Arrays;


public class 二分查找 {

    static int binarySearch(int[] arr, int val, char type) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            System.out.printf("\thit A[(%2d + %2d) // 2 = %2d] = %d\n", l, r, m, arr[m]);
            if (arr[m] == val) {
                switch (type) {
                    case 'V':
                        return m;
                    case 'L':
                        r = m - 1;
                        break;
                    case 'R':
                        l = m + 1;
                        break;
                }
            } else if (arr[m] < val) {
                l = m + 1;
            } else if (arr[m] > val) {
                r = m - 1;
            }
        }

        switch (type) {
            case 'L':
                return l;
            case 'R':
                return r;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                // {find, targetV, targetL, targetR}, arr
                {{-1, -1, 0, -1}, {}},
                {{4, -1, 2, 1}, {2, 3, 5, 7}},
                {{3, 1, 1, 1}, {2, 3, 5, 7}},
                {{5, 2, 1, 3}, {1, 5, 5, 5, 9}},
                {{3, -1, 1, 0}, {1, 5, 5, 5, 9}},
                {{7, -1, 4, 3}, {1, 5, 5, 5, 9}},
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

            System.out.printf("find %d get (%d, %d, %d) from %s\n",
                    findVal, v, l, r, Arrays.toString(arr));
            EasyAssert.AssertEqual(v, targetV);
            EasyAssert.AssertEqual(l, targetL);
            EasyAssert.AssertEqual(r, targetR);
        }
    }

}
