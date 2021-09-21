//! 简单选择排序（升序）
void simpleSelectSort(int arr[], int len) {
    for (int i = 0; i < len; i++) {
        // 获取[i, len - 1]中的最小值
        int m = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[m]) m = j;
        }
        swapValue(arr, m, i);
    }
}