//! 折半插入排序（升序）
void binaryInsertSort(int arr[], int len) {
    for (int i = 1; i < len; i++) {
        int l = 0, m, r = i - 1, v = arr[i];
        // 二分查找探测右边界
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
}