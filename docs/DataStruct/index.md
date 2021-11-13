<link rel="stylesheet" href="https://zhmhbest.gitee.io/hellomathematics/style/index.css">
<script src="https://zhmhbest.gitee.io/hellomathematics/style/index.js"></script>

# [数据结构](../index.html)

[TOC]

## 线性表

### 顺序结构

### 链表结构

- 单链表
- 双链表
- 循环链表

### 栈（Stack）

先进后出

- 栈空：`-1 == top`
- 栈满：`top + 1 == MAX_SIZE`
- 数量：`top + 1`

### 队列（Queue）

先进先出

- 链队列
- 循环队列：需要留空一个位置判断队满
  - 队空：`rear == front`
  - 队满：`(rear + 1) % MAX_SIZE == front`
  - 数量：`(rear - front + MAX_SIZE) % MAX_SIZE`
- 双端队列：同时具有栈和队列的性质

## 串

**空串**：`""`

**字串**：串中任意个连续字符组成的子序列

### 串的表示

- 顺序存储
- 堆分配存储
- 块链存储

### 串的模式匹配

- 求子串位置

## 树

### 表示方法

- 树形表示法
- 嵌套集合表示法
- 凹入表示法
- 广义表表示法

### 二叉树

- 深度为$n$的二叉树至多有$2^n-1$个节点
- 第$i$层至多有$2^{i-1}$个节点

#### 存储结构

- 顺序存储
- 链式存储

#### 遍历

- 前序遍历
- 中序遍历
- 后续遍历

### 线索二叉树

<table>
<tr>
<td>lchild</td><td>ltag</td>
<td>data</td>
<td>rtag</td><td>rchild</td>
</tr>
</table>

### 树和森林

#### 表示法

- 双亲表示法
- 孩子表示法
- 孩子兄弟表示法

#### 转化为二叉树

**树转换为二叉树**：

1. 同层相连
2. 每层与上层仅保留最左侧链接

**森林转为二叉树**：

1. 将每颗树转为二叉树
2. 第二颗树作为第一颗的右子树，依次类推

### Huffman

**带权路径长度**：从树根到某一节点的路径长度与该节点的权的乘积。

**构建**：选出最小的两个作为左右子树，构建出一颗新二叉树，其根为两数之和作为新元素替代原有两个元素参与后续构建，重复上述步骤直到不能凑齐两个元素。

**编码**：每条路径权值为0或1（一般左0右1），每个元素编码为从根到该元素所有路径的权值组成的数字。

## 图

## 查找

## [内排序](./InnerSorting/index.html)

### [直接插入排序](./InnerSorting/index.html#直接插入排序)

### [折半插入排序](./InnerSorting/index.html#折半插入排序)

### [简单选择排序](./InnerSorting/index.html#简单选择排序)

### [堆排序](./InnerSorting/index.html#堆排序)

### [冒泡排序](./InnerSorting/index.html#冒泡排序)

### [快速排序](./InnerSorting/index.html#快速排序)
