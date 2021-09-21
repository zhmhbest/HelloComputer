package org.example.Sort;

import org.example.EasyAssert;
import org.example.IO;

import java.util.Arrays;

public class 基本排序算法 {
    /**
     * 直接插入排序（升序）
     */
    static int[] directInsertSort(int[] arr, int len) {
        for (int i = 1; i < len; i++) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0 && v < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }
        return arr;
    }

    /**
     * 折半插入排序
     */
    static int[] binaryInsertSort(int[] arr, int len) {
        for (int i = 1; i < len; i++) {
            int l = 0, m, r = i - 1, v = arr[i];
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[m] <= v) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } // 插入位置为(r+1)
            int j = i - 1;
            while (j > r) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }
        return arr;
    }

    /**
     * 简单选择排序
     */
    static int[] simpleSelectSort(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            // 获取[i, len - 1]中的最小值
            int m = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[m]) m = j;
            }
            swapValue(arr, m, i);
        }
        return arr;
    }

    /**
     * 构建大顶堆
     */
    static void heapAdjust(int[] arr, int len, int i) {
        // i为被调整节点
        int iL = 2 * i + 1; // i 的左子节点
        int iR = 2 * i + 2; // i 的右子节点

        // 选出当前结点与其子结点中最大的结点记为j
        int j = i;
        if (iL < len && arr[iL] > arr[j]) j = iL;
        if (iR < len && arr[iR] > arr[j]) j = iR;

        // 最大结点交换到当前根，并传递调整
        if (j != i) {
            swapValue(arr, j, i);
            heapAdjust(arr, len, j);
        }
    }

    /**
     * 堆排序
     */
    static int[] heapSelectSort(int[] arr, int len) {
        // 【构建大顶堆】
        // 所有非叶节点：[0, len / 2 - 1]
        for (int i = len / 2 - 1; i >= 0; i--) heapAdjust(arr, len, i);
        // 【调整大顶堆】
        for (int i = len - 1; i >= 1; i--) {
            swapValue(arr, i, 0);  // 将当前最大的放置到数组末尾
            heapAdjust(arr, i, 0); // 将未完成排序的部分继续进行堆排序
        }
        return arr;
    }

    /**
     * 冒泡排序
     */
    static int[] bubbleSwapSort(int[] arr, int len) {
        // [0 →i→ (len-1)]
        for (int i = 0; i < len; i++) {
            // [(i+1) ←j← (len-1)] 每次从[i, len-1]中冒泡出一个最小值保存到i的位置
            for (int j = len - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swapValue(arr, j - 1, j);
                }
            }
        }
        return arr;
    }

    static void arrayAdjust(int[] arr, int boundL, int boundR) {
        // 每轮确定一个中间数arr[p]的位置
        int p = boundR; // 此处使用右值
        int l = boundL;
        int r = boundR - 1; // 因为使用了右值所以减少一个位置

        for (; ; ) {
            // 期望左侧数据小于等于中间数
            while (l < r && arr[l] <= arr[p]) l++;
            // 期望右侧数据大于等于中间数
            while (l < r && arr[r] >= arr[p]) r--;

            // 最终一定是l == r
            // 该位置为中间数在[boundL, boundR - 1]中的理想位置
            // 若中间数是[boundL, boundR]中的最大值，则存在不需变动的可能性
            if (l == r) {
                // 定位切割数
                if (arr[p] >= arr[l]) {
                    // 中间数不需变动（此时l + 1 = p）
                    l = p;
                } else {
                    swapValue(arr, l, p);
                }
                break;
            }

            // 不满足期望，交换两侧数据
            swapValue(arr, l, r);
        }
        if (boundL < (l - 1)) arrayAdjust(arr, boundL, l - 1);
        if ((l + 1) < boundR) arrayAdjust(arr, l + 1, boundR);
    }

    /**
     * 快速排序
     */
    static int[] quickSwapSort(int[] arr, int len) {
        if (len > 1) arrayAdjust(arr, 0, len - 1);
        return arr;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = IO.generateRandomIntArray(50);
            int[] tgt = arr.clone();
            Arrays.sort(tgt);
            System.out.printf("arr = %s\n", Arrays.toString(arr));
            System.out.printf("tgt = %s\n", Arrays.toString(tgt));
            System.out.println();
            EasyAssert.AssertEqual(tgt, directInsertSort(arr.clone(), arr.length));
            EasyAssert.AssertEqual(tgt, binaryInsertSort(arr.clone(), arr.length));
            EasyAssert.AssertEqual(tgt, simpleSelectSort(arr.clone(), arr.length));
            EasyAssert.AssertEqual(tgt, heapSelectSort(arr.clone(), arr.length));
            EasyAssert.AssertEqual(tgt, bubbleSwapSort(arr.clone(), arr.length));
            EasyAssert.AssertEqual(tgt, quickSwapSort(arr.clone(), arr.length));
        }
    }

    static void swapValue(int[] arr, int i, int j) {
        int dump = arr[i];
        arr[i] = arr[j];
        arr[j] = dump;
    }
}
