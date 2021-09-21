package org.example.Bit;

import org.example.EasyAssert;

/**
 * 除一个数字只出现一次之外，其他数字都出现了三次。
 */
public class 只出现一次的数字 {
    // 有限状态自动机
    static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(4, singleNumber(new int[]{3, 4, 3, 3}));
        EasyAssert.AssertEqual(1, singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
        System.out.println("OK");
    }
}
