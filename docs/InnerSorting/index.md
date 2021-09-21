<link rel="stylesheet" href="https://zhmhbest.gitee.io/hellomathematics/style/index.css">
<script src="https://zhmhbest.gitee.io/hellomathematics/style/index.js"></script>

# [内排序算法](../index.html)

[TOC]

## 插入排序

### 直接插入排序

@import "./tables/insertion-sort.html"

- 稳定
- 空间复杂度：$O(1)$
- 时间复杂度：$O(n^2)$
  - 序列完全正序：仅需比较$n-1$次
  - 序列完全逆序：比较$\sum\limits_{i=2}^{n}(i)$次、移动$\sum\limits_{i=2}^{n}(i+1)$次
  - 序列基本有序：$O(n)$
- 适应性：随着排序的的进行，序列变得基本有序，算法效率逐渐提高。

@import "src/insertion-sort.c"

```txt
输入 A, N
循环 i ∈ [1, N - 1]
    j = i - 1, v = A[i]
    循环当 j ≥ 0 且 v < A[j]
        A[j + 1] = A[j]
        j--
    A[j + 1] = v
```

### 折半插入排序

@import "src/binary-insertion-sort.c"

```txt
输入 A, N
循环 i ∈ [1, N-1]
    l = 0, r = i - 1, v = A[i]
    循环当 l ≤ r
        m = (l + r) / 2
        若 A[m] <= v 则 l = m + 1 否则 r = m - 1
    j = i - 1
    循环当 j > r
        A[j + 1] = A[j]
        j--
    A[j + 1] = v
```

### 希尔排序

@import "./tables/shell-sort.html"

- 不稳定
- 空间复杂度：$O(1)$
- 大概时间复杂度：$O(n^{\frac{3}{2}})$（由于数学问题，无法准确描述）
- 适应性：由于希尔排序基于插入排序，希尔排序继承了插入排序的自适应性，但适应性较直接插入排序弱。

@import "./src/shell-sort.c"

## 选择排序

### 简单选择排序

>在交换单位的消耗成本很高的应用中，选择排序很可能也是合适的算法选择。

@import "./tables/selection-sort.html"

- 不稳定
- 空间复杂度：$O(1)$
- 时间复杂度：$O(n^2)$
- 不适应性

@import "./src/selection-sort.c"

```txt
输入 A, N
循环 i ∈ [0, N - 1]
    m = i
    循环 j ∈ [i + 1, N - 1]
        若 A[j] < A[m] 则 m = j
    交换 A[i], A[m] 的值
```

### 堆排序

@import "./tables/heap-sort.html"

- 不稳定
- 空间复杂度：$O(1)$
- 时间复杂度：$O(n \cdot \log_{2}n)$
- 没有真正适应

@import "./src/heap-sort.c"

```txt
输入 A, N
循环 i ∈ [N/2 - 1, 0]
    heapAdjust(A, N, i)
循环 i ∈ [N - 1, 1]
    交换 A[i], A[0] 的值
    heapAdjust(A, i, 0)

heapAdjust:
    输入 A, N, I
    l = 2 × I + 1
    r = 2 × I + 2

    j = I
    若 l < N 且 A[l] > A[j] 则 j = l
    若 r < N 且 A[r] > A[j] 则 j = r

    若 j ≠ I 则
        交换 A[j], A[I] 的值
        heapAdjust(A, N, j)
```

@import "./graphs/heap-sort.md"

## 交换排序

### 冒泡排序

@import "./tables/bubble-sort.html"

- 稳定
- 空间复杂度：$O(1)$
- 时间复杂的：$O(n^2)$
  - 基本有序：$O(n)$
- 适应性

@import "./src/bubble-sort.c"

```txt
输入 A, N
循环 i ∈ [0, N - 1]
    循环 j ∈ [N - 1, i)
        若 A[j - 1] > A[j] 则 交换 A[j - 1], A[j] 的值
```

### 快速排序

>通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小。

@import "./tables/quick-sort.html"

- 不稳定
- 空间复杂度：$O(\log_{2}n)$
- 时间复杂度：$O(n^2)$，但通常$O(n \cdot log_{2}n)$
- 没有真正适应

@import "./src/quick-sort.c"

```txt
输入 A, N
若 N > 1 则 arrayAdjust(A, 0, N - 1)

arrayAdjust:
    输入 A, L, R
    l = L, r = R, v = A[l]
    循环当 l < r
        循环当 l < r 且 A[r] ≥ A[p]
            r--
        A[l] = A[r]
        循环当 l < r 且 A[l] ≤ A[p]
            l++
        A[r] = A[l]
    A[l] = v
    若 L < (l - 1) 则 arrayAdjust(A, L, l - 1)
    若 (l + 1) < R 则 arrayAdjust(A, l + 1, R)
```

@import "./graphs/quick-sort.md"

### 快速排序三平均

@import "./tables/quick-sort-3-way.html"

- 不稳定
- 空间复杂度：$O(\log_{2}n)$
- 时间复杂度：$O(n^2)$，但通常$O(n \cdot log_{2}n)$
- 自适应：当有$O(1)$个**Unique Keys**时需要$O(n)$时间

## 归并排序

@import "./tables/merge-sort.html"

- 稳定性
- 数组要$O(n)$额外空间；链表要$O(\log_{2}n)$额外空间
- $O(n \cdot \log_{2}n)$时间
- 不自适应
- 不需要随机接入数据

## 基数排序

略

<!-- 用于刷新GIF -->
@import "./tables/initial-tables.html"
