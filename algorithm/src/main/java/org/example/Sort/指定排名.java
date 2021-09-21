package org.example.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 指定排名 {
    static String[] findRelativeRanks(int[] arr) {
        Map<Integer, String> rankLabel = new HashMap<Integer, String>(){{
            put(1, "金牌");
            put(2, "银牌");
            put(3, "铜牌");
        }};
        // (成绩, 下标) TreeMap自动按成绩升序排序
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);

        String[] buffer = new String[arr.length];
        int count = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            // 计算成绩的排名
            int rank = arr.length - count++;
            buffer[set.getValue()] = rankLabel.containsKey(rank) ? rankLabel.get(rank) : String.valueOf(rank);
        }
        return buffer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 2, 3, 4, 1})));
    }
}
