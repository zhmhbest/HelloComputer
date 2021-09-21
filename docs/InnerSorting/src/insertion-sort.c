//! 直接插入排序（升序）
void directInsertSort(int arr[], int len) {
    for (int i = 1; i < len; i++) {
        int j = i - 1;
        int v = arr[i];
        while (j >= 0 && v < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = v;
    }
}