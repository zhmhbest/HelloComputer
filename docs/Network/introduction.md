
用于实现**资源共享**和**信息传递**的系统。

### 计算机网络分类

- 按作用范围：广域网（WAN）、城域网（MAN）、局域网（LAN）、个人区域网（PAN）
- 按使用者：公用网、专用网

### 性能指标

#### 速率

数据传送速率。

$$
\textnormal{\footnotesize 比特率} = \dfrac{
    \textnormal{\footnotesize 传送比特量}
}{
    \textnormal{\footnotesize 秒}
}
$$

#### 带宽

原指最高频率与最低频率之差。在计算机网络中，带宽表示通信线路传送能力（最高速率）。

#### 吞吐量

单位时间内通过某个网络（信道、接口）的数据量。

#### 时延

数据从一端传送到另一端所需的时间。

- $\textnormal{\footnotesize 时延 = 发送时延 + 传播时延 + 排队时延 + 处理时延}$
- $\textnormal{\footnotesize 时延带宽积 = 传播时延 × 带宽}$<span class='hint'>（描述了链路数据容量）</span>
- $\textnormal{\footnotesize RTT = 传播时延 × 2 + 中间结点转发时间 × 2 + 末端处理时间}$

#### 利用率

$$
    \textnormal{\footnotesize 信道利用率} =
    \dfrac{
        \textnormal{\footnotesize 有数据通过的时间}
    }{
        \textnormal{\footnotesize 有数据通过的时间}
        +
        \textnormal{\footnotesize 无数据通过的时间}
    }
$$

信道利用率并非越高越好。

### 计算机网络体系结构

@import "tables/osi.html"

#### 网络协议

为进行网络中数据交换而建立的规则/标准/约定。包含**语法**、**语义**、**同步**三个要素。

#### 集线器、交换机、路由器区别

| 区别 | 集线器 | 网桥/交换机 | 路由器 |
| - | - | - | - | - |
| **工作层次** | 物理层 | 数据链路层 | 网络层 |
| **寻址依据** | 广播 | MAC地址 | IP地址 |
| **转发对象** | 数字信号 | 数据帧 | 分组报文 |
| **域分割** | 不能分割冲突域 | 只能分割冲突域 | 可以分割广播域 |
