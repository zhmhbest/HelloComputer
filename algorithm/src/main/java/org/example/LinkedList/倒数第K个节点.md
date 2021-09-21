# 倒数第K个节点

- `former`、`latter`指向起点
- `former`先走$k$步
- `former`、`latter`一起走直到`former`指空。

```txt
输入 L, K
former = L, latter = L
循环K次
    former = former.next
循环当 former ≠ NULL
    former = former.next
    latter = latter.next
返回 latter
```
