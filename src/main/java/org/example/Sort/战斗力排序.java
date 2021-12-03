package org.example.Sort;

import org.example.IO;

import java.util.*;

public class 战斗力排序 {

    static int getRowWeight(int[] row) {
        // 二分查找1的位置
        int l = 0, m, r = row.length - 1, p = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (1 == row[m]) {
                l = m + 1;
                p = m;
            } else {
                r = m - 1;
            }
        }
        return p + 1;
    }

    /**
     * TreeMap
     */
    static int[] kWeakestRowsByTreeMap(int[][] mat, int k) {
        // (权重, 下标)
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            int w = getRowWeight(mat[i]);
            if (map.containsKey(w)) {
                map.get(w).add(i);
            } else {
                List<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(w, l);
            }
        }
        int[] holder = new int[k];
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> set : map.entrySet()) {
            for (int j = 0; j < set.getValue().size(); j++) {
                holder[i++] = set.getValue().get(j);
                if (i >= k) return holder;
            }
        }
        return null;
    }

    /**
     * PriorityQueue
     */
    static int[] kWeakestRowsByPriorityQueue(int[][] mat, int k) {
        // (权重, 小标)
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1[0], o2[0]) * 2 + Integer.compare(o1[1], o2[1])
        );
        for (int i = 0; i < mat.length; i++) {
            queue.offer(new int[]{getRowWeight(mat[i]), i});
        }
        int[] holder = new int[k];
        int i = 0;
        while(!queue.isEmpty()) {
            // System.out.println(Arrays.toString(queue.poll()));
            holder[i++] = queue.poll()[1];
            if (i >= k) return holder;
        }
        return null;
    }

    public static void main(String[] args) {
        //  1 总是出现在 0 之前
        int[][] mat1 = IO.parseMatrix("" +
                "[[1,1,0,0,0]," +
                " [1,1,1,1,0]," +
                " [1,0,0,0,0]," +
                " [1,1,0,0,0]," +
                " [1,1,1,1,1]]");
        System.out.println(Arrays.toString(kWeakestRowsByTreeMap(mat1, 3)));
        System.out.println(Arrays.toString(kWeakestRowsByPriorityQueue(mat1, 3)));

        int[][] mat2 = IO.parseMatrix("" +
                "[[1,0,0,0]," +
                " [1,1,1,1]," +
                " [1,0,0,0]," +
                " [1,0,0,0]]");
        System.out.println(Arrays.toString(kWeakestRowsByTreeMap(mat2, 2)));
        System.out.println(Arrays.toString(kWeakestRowsByPriorityQueue(mat2, 2)));
    }
}
