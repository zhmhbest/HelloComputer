# K个一组反转列表

```txt
输入 L, K
rH = NULL, pT = NULL
cH = L, cT, nH
循环
    rK, cH, cT, nH = reverseKLengthList(cH, K)
    若 0 ≠ rK 则
        rK, cH, cT, nH = reverseKLengthList(cH, K - rK)
    若 rH == NULL 则 rH = cH
    若 pT  ≠ NULL 则 pT.next = cH
    pT = cT, cH = nH
    若 nH == NULL 则 退出循环
返回 rH
```