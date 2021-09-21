package org.example.Graph;

import java.util.List;

public class MatrixGraph {
    int[][] matrix;

    public MatrixGraph(List<List<Integer>> data) {
        final int rowSize = data.size();
        final int colSize = data.get(0).size();
        this.matrix = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            List<Integer> rowData = data.get(i);
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = rowData.get(j);
            }
        }
    }
}
