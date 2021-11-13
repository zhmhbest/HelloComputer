//! 构建大顶堆
void heapAdjust(int arr[], int len, int i) {
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

//! 堆排序（升序）
void heapSelectSort(int arr[], int len) {
    // 【构建大顶堆】
    // 所有非叶节点：[0, len / 2 - 1]
    for (int i = len / 2 - 1; i >= 0; i--) heapAdjust(arr, len, i);
    // 【调整大顶堆】
    for (int i = len - 1; i >= 1; i--) {
        swapValue(arr, i, 0);  // 将当前最大的放置到数组末尾
        heapAdjust(arr, i, 0); // 将未完成排序的部分继续进行堆排序
    }
}