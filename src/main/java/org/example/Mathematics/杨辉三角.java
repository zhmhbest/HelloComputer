package org.example.Mathematics;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    /**
     * 生成整个杨辉三角
     */
    static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> holder = new ArrayList<>();
        List<Integer> lastRow = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) { // 第i行有(i+1)个
                if (j == 0 || j == i) { // 每行开头结尾=1
                    row.add(1);
                } else {
                    assert lastRow != null;
                    // 观察可知，由上行同列元素与前列元素相加获得
                    row.add(lastRow.get(j) + lastRow.get(j - 1));
                }
            }
            lastRow = row;
            holder.add(row);
        }
        return holder;
    }

    /**
     * 生成指定行的杨辉三角
     */
    static List<Integer> getPascalTriangleRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 0; i < rowIndex; i++) {
            row.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j) + lastRow.get(j - 1));
                }
            }
            // 交换row, lastRow
            tmp = lastRow;
            lastRow = row;
            row = tmp;
        }
        return lastRow;
    }

    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(3));
        // [[1], [1, 1], [1, 2, 1]]

        System.out.println(generatePascalTriangle(5));
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        System.out.println(getPascalTriangleRow(3));
        // [1, 2, 1]

        System.out.println(getPascalTriangleRow(5));
        // [1, 4, 6, 4, 1]
    }
}
