package org.example.Array;

import org.example.EasyAssert;

public class 旋转数组的最小数字 {

    static int minArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                // m在断点右侧
                r = m;
            } else if (nums[m] > nums[r]) {
                // m在断点左侧
                l = m + 1;
            } else {
                // m就是右侧最大值
                r -= 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        // 数据中存在一个间断点，间断点两侧数据单调递增
        EasyAssert.AssertEqual(1, minArray(new int[]{3, 4, 5, 1, 2}));
        EasyAssert.AssertEqual(0, minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println("OK");
    }

}
