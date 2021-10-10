# HelloMap

## HashMap

>- JDK1.7：Entry数组 + 链表
>- JDK1.8：Node 数组 + 链表/红黑树，当链表上的元素个数超过 8 个并且数组长度 >= 64 时自动转化成红黑树。

- `key`和`value`可以为`null`。
- 默认为实现线程安全访问，但可以通过`Collections.synchronizedMap(map);`实现线程安全。

## HashTable

- `key`和`value`不允许为`null`。
- `synchronized`实现的线程安全，但多线程访问会导致操作串行化（效率差）。
