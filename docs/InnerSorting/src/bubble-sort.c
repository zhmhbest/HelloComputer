//! 冒泡排序（升序）
void bubbleSwapSort(int arr[], int len) {
    // [0 →i→ (len-1)]
    for (int i = 0; i < len; i++) {
        // [(i+1) ←j← (len-1)] 每次从[i, len-1]中冒泡出一个最小值保存到i的位置
        for (int j = len - 1; j > i; j--) {
            if (arr[j - 1] > arr[j]) {
                swapValue(arr, j - 1, j);
            }
        }
    }
}