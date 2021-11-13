static void arrayAdjustL(int arr[], int boundL, int boundR) {
    int l = boundL;
    int r = boundR;
    int v = arr[l];
    while (l < r) {
        // 期望右侧数据大于等于中间数
        while (l < r && arr[r] >= v) r--;
        arr[l] = arr[r];
        // 期望左侧数据小于等于中间数
        while (l < r && arr[l] <= v) l++;
        arr[r] = arr[l];
    }
    arr[l] = v;
    if (boundL < (l - 1)) arrayAdjustL(arr, boundL, l - 1);
    if ((l + 1) < boundR) arrayAdjustL(arr, l + 1, boundR);
}

//! 快速排序（升序）
void quickSwapSort(int arr[], int len) {
    if (len > 1) arrayAdjustL(arr, 0, len - 1);
}