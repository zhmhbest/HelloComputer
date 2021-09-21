# 第N个丑数

**丑数**，即$1$或因子仅含$2$、$3$、$5$的整数。

## 小顶堆

若$x$是丑数，则$2x$、$3x$、$5x$也是丑数。

```java
static int nthUglyNumber(int n) {
    final int[] factors = {2, 3, 5};
    // 用于去重
    Set<Integer> seen = new HashSet<Integer>() {{ add(1); }};
    // 用于自动排序
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(){{ offer(1); }};
    int ugly = 0;
    for (int i = 0; i < n; i++) {
        ugly = queue.poll();
        for (int factor : factors) {
            int val = ugly * factor;
            if (seen.add(val)) queue.offer(val);
        }
    }
    return ugly;
}
```

## 动态规划

**地推公式**：$x_{n+1} = min(2x_a, 3x_b, 5x_c)$

**索引条件**：$
    \begin{cases}
        2x_{a-1} ≤ x_n < 2x_{a}
    \\  3x_{b-1} ≤ x_n < 3x_{b}
    \\  5x_{c-1} ≤ x_n < 5x_{c}
    \end{cases}
$

| 序号 |  1   |  2   |  3   |  4   |  5   |  6   |  7   |  8   |  9   |  10  |
| ---: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| 丑数 | $1$  | $2$  | $3$  | $4$  | $5$  | $6$  | $8$  | $9$  | $10$ | $12$ |

```java
static int nthUglyNumber(int n) {
    int a = 0, b = 0, c = 0;
    int[] dp = new int[n]; dp[0] = 1;
    for (int i = 1; i < n; i++) {
        int n2 = dp[a] * 2;
        int n3 = dp[b] * 3;
        int n5 = dp[c] * 5;
        // 当前丑数
        int xn = Math.min(Math.min(n2, n3), n5);
        // 更新索引
        if (xn == n2) a++;
        if (xn == n3) b++;
        if (xn == n5) c++;
        // 第i+1个丑数为
        dp[i] = xn;
    }
    return dp[n - 1];
}
```
