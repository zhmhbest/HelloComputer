package org.example.Mathematics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 相加为指定值的两个元素下标 {
    /**
     * 枚举法
     * 每拿到一个值，都与该值之后的值比比能不能凑一对
     */
    // static int[] twoSum(int[] nums, int target) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (target == nums[i] + nums[j]) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return null;
    // }

    /**
     * 单循环解决问题
     * 每次拿到一个新值都与之前的比比看看能不能凑一对
     */
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value, index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
                // return new int[]{nums[map.get(complement)], nums[i]};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 22)));
    }
}
