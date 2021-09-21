package org.example.Matrix;

import org.example.IO;

public class 顺时针遍历矩阵 {
    /**
     * 顺时针遍历矩阵
     *
     * @param rowLength 行数
     * @param colLength 列数
     */
    static void clockwiseOrderPrint(int rowLength, int colLength) {
        if (0 == rowLength || 0 == colLength) return;
        int[][] holder = new int[rowLength][colLength];

        int index = 0;
        int boundT = 0, boundB = rowLength - 1;
        int boundL = 0, boundR = colLength - 1;

        while (boundL <= boundR && boundT <= boundB) {
            // 上行
            for (int col = boundL; col <= boundR; col++) {
                holder[boundT][col] = index;
                index++;
            }
            // 右列
            for (int row = boundT + 1; row <= boundB; row++) {
                holder[row][boundR] = index;
                index++;
            }
            // 下行
            if (boundT == boundB) break; // 上下同行
            for (int col = boundR - 1; col >= boundL; col--) {
                holder[boundB][col] = index;
                index++;
            }
            // 左列
            if (boundL == boundR) break; // 左右同列
            for (int row = boundB - 1; row > boundT; row--) {
                holder[row][boundL] = index;
                index++;
            }
            boundT++; boundR--;
            boundB--; boundL++;
        }
        IO.printMatrix(holder);
    }

    public static void main(String[] args) {
        final int sideLength = 6;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.printf("(%d, %d)\n", i, j);
                clockwiseOrderPrint(i, j);
                if (i != j) clockwiseOrderPrint(j, i);
            }
        }
    }
}
