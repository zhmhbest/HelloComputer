//! 希尔排序（升序）
void shellInsertionSort(int arr[], int len) {
    for (int step = len / 2; step > 0; step /= 2) {
        for (int i = step; i < len; i++) {
            int j = i,
                k = j - step,
                dump = arr[j];
            // 直接插入排序
            while (k >= 0 && arr[k] > dump) {
                arr[j] = arr[k];
                j = k;
                k = j - step;
            }
            arr[j] = dump;
        }
    }
}