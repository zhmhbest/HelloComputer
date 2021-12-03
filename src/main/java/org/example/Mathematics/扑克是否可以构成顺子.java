package org.example.Mathematics;

import java.util.HashSet;
import java.util.Set;

/**
 * 随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 2~10: 数字本身
 * A: 1
 * J: 11
 * Q: 12
 * K: 13
 */
public class 扑克是否可以构成顺子 {

    static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;                     // 跳过大小王
            max = Math.max(max, num);                   // 最大牌
            min = Math.min(min, num);                   // 最小牌
            if (repeat.contains(num)) return false;     // 若有重复，提前返回 false
            repeat.add(num);                            // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
    }

}
