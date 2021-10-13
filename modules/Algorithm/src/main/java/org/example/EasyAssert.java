package org.example;

import java.util.Arrays;
import java.util.List;

public class EasyAssert {
    public static void Assert(boolean statement) {
        if(!statement) {
            throw new AssertionError();
        }
    }

    public static void AssertEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) throw new AssertionError();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) throw new AssertionError(String.format(
                    "arr1[%d]=%d, arr2[%d]=%d\narr1 = %s\narr2 = %s",
                    i, arr1[i], i, arr2[i],
                    Arrays.toString(arr1),
                    Arrays.toString(arr2)
            ));
        }
    }

    public static void AssertEqual(List<Integer> lst1, int[] arr2) {
        if (lst1.size() != arr2.length) throw new AssertionError();
        for (int i = 0; i < arr2.length; i++) {
            if (lst1.get(i) != arr2[i]) throw new AssertionError(String.format(
                    "arr1[%d]=%d, arr2[%d]=%d\narr1 = %s\narr2 = %s",
                    i, lst1.get(i), i, arr2[i],
                    lst1,
                    Arrays.toString(arr2)
            ));
        }
    }

    public static void AssertEqual(int[] arr1, List<Integer> lst2) {
        AssertEqual(lst2, arr1);
    }

    public static void AssertEqual(int val1, int val2) {
        if (val1 != val2) throw new AssertionError(String.format("%d ≠ %d", val1, val2));
    }

    public static void AssertEqual(boolean val1, boolean val2) {
        if (val1 != val2) throw new AssertionError(String.format("%b ≠ %b", val1, val2));
    }

    public static void AssertNPlus(int[] arr) {
        for (int val : arr) {
            if (val <= 0) throw new AssertionError(String.format("%d ≤ 0", val));
        }
    }

    public static void AssertNPlus(long[] arr) {
        for (long val : arr) {
            if (val <= 0) throw new AssertionError(String.format("%d ≤ 0", val));
        }
    }
}
