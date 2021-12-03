package org.example.Matrix;

import org.example.EasyAssert;

public class 从蛇形矩阵获取目标位置 {
    /**
     * 从蛇形矩阵获取目标位置
     *
     * @return (row, col)
     */
    static int[] getPositionFromClockwiseMatrix(int sideLength, int target) {
        if (0 == sideLength) return new int[]{-1, -1};

        int index = 1;
        int boundT = 0, boundB = sideLength - 1;
        int boundL = 0, boundR = sideLength - 1;

        while (boundL <= boundR && boundT <= boundB) {
            // 上行
            for (int col = boundL; col <= boundR; col++) {
                if (index == target) return new int[]{boundT + 1, col + 1};
                index++;
            }
            // 右列
            for (int row = boundT + 1; row <= boundB; row++) {
                if (index == target) return new int[]{row + 1, boundR + 1};
                index++;
            }
            // 下行
            if (boundT == boundB) break; // 上下同行
            for (int col = boundR - 1; col >= boundL; col--) {
                if (index == target) return new int[]{boundB + 1, col + 1};
                index++;
            }
            // 左列
            if (boundL == boundR) break; // 左右同列
            for (int row = boundB - 1; row > boundT; row--) {
                if (index == target) return new int[]{row + 1, boundL + 1};
                index++;
            }
            boundT++;
            boundR--;
            boundB--;
            boundL++;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(new int[]{3, 3}, getPositionFromClockwiseMatrix(5, 25));
        EasyAssert.AssertEqual(new int[]{2, 4}, getPositionFromClockwiseMatrix(5, 19));
        EasyAssert.AssertEqual(new int[]{5, 1}, getPositionFromClockwiseMatrix(5, 13));
        System.out.println("OK");
    }
}
