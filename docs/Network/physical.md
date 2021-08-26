### 基本特性

机械、电气、功能、过程

### 传输介质

#### 导向性

双绞线（屏蔽双绞线STP、无屏蔽双绞线UTP）、同轴电缆（基带、宽带）、光缆（单模、多模）

#### 非导向性

无线电、微波（固定方向）、红外/激光（固定方向）

### 数据通信

#### 信号分类

模拟信号、数字信号

#### 通信方式

单工、半双工、全双工

#### 码元

时间间隔相同的符号来表示一个二进制数字，这样的时间间隔内的信号称为（二进制）码元。码元传输单位为波特（Baud），表示每秒传输几个码元。

#### 编码方式

| 编码方式 | 编码为1 | 编码为0 |
| - | - | - |
| **不归零制** | 正电平 | 负电平 |
| **归零制** | 正脉冲 | 负脉冲 |
| **反向归零制** | 电平不变 | 电平翻转 |
| **曼彻斯特编码** | 位周期中心下跳 | 位周期中心上跳 |
| **差分曼彻斯特编码** | 开始边界无跳变 | 开始边界有跳变 |

#### 带通调制方式

调幅（AM）、调频（FM）、调相（PM）

#### 码间串扰

因为码元发送频率过高，导致接收到的信号波形失去了码元间清晰的界限的现象。

#### 奈氏准则

$$\textnormal{\footnotesize 理想低通信道下的极限数据传输率（比特/秒）} = 2W\log_2{V}$$

- $W$: 信道带宽，单位为Hz
- $V$：有几种码元

#### 香农定理

$$\textnormal{\footnotesize 极限数据传输率（比特/秒）} = W\log_2{(1 + S/N)}$$

- $S/N$：信噪比，$S/N = 10log_{10}(\textnormal{\footnotesize db信噪比})$

### 信道复用

频分、时分、统计时分、波分、码分