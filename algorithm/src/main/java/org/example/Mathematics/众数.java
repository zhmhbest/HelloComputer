package org.example.Mathematics;

public class 众数 {

    static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        for (int num : nums) {
            if (0 == count) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        final int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr1));
    }
}
