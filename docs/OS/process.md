
### 进程

#### 进程实体

$$\textnormal{\footnotesize 进程实体（进程映像）} = \{\textnormal{\footnotesize 程序段（程序代码）}, \textnormal{\footnotesize 数据段（程序运行时数据）}, PCB\}$$

- $PCB$包含了进程的描述信息、流程和管理信息、资源分配清单、处理机相关信息。
- **创建进程**就是创建进程实体中的PCB。
- **撤销进程**就是撤销进程实体中的PCB。

#### 进程的定义

进程是进程实体的运行过程，是系统进行资源分配和调度的一个独立单位。

#### 进程的组织

```mermaid
graph LR
    style 链接方式 fill:#888;
    style 索引方式 fill:#888;
    subgraph 链接方式
        pA1([执行指针])-->PCB11;
        pA2([就绪队列指针])-->PCB12-->PCB13-->PCB14;
        pA3([阻塞队列指针])-->PCB15-->PCB16-->PCB17;
    end
    subgraph 索引方式
        pB1([执行指针])-->PCB21;
        pB2([就绪队列指针])-->table1[[就绪索引表]];
        pB3([阻塞队列指针])-->table2[[阻塞索引表]];
    end
```

#### 进程的特征

- 动态性：最基本特征
- 并发性
- 独立性：资源分配、调度的独立单位
- 异步性：不可预知的速度推进，可能导致结果的不确定性
- 结构性

#### 进程的状态

- 运行态：独占CPU的一个物理内核运行
- 就绪态：已具备运行条件（运行所需资源），等待CPU空闲即可执行
- 阻塞态：等待事件触发后进入就绪态
- 创建态：OS为进程分配资源、初始化PCB
- 终止态：OS回收进程资源，撤销PCB

```mermaid
flowchart TD
    style create fill:LightGray,stroke:Blue;
    style stop fill:LightGray,stroke:Blue;
    style running fill:SpringGreen,stroke:Blue;
    style block fill:OrangeRed,stroke:Blue;
    style ready fill:Yellow,stroke:Blue;
    create([创建态]);
    ready([就绪态]);
    running([运行态]);
    stop([终止态]);
    block([阻塞态]);
    create-->ready<===>running-->stop;
    running-->block-->ready;
```

相关原语：创建、终止、阻塞、唤醒、切换。

#### 进程通信

- 共享存储系统
- 管道通信：半双工通信，没有写满不能读，没有读空不能写。
- 消息传递
  - 直接通信：直接挂到接受进程的消息缓冲队列
  - 间接通信：先发送到信箱

### 线程

>没有引入线程时，传统的进程是程序执行流的最小单位。

**进程是资源分配的基本单位**；**线程是调度的基本单位**。同一进程的线程间并发不需要切换进程的运行环境。

#### 线程的实现方式

|                | 用户级线程（协程） |  内核级线程  |
| -----------------: | :----------------: | :----------: |
|             维护者 |      应用程序      | 操作系统内核 |
|         线程切换态 |       用户态       |    核心态    |
|     操作系统可见性 |       不可见       |     可见     |
|     等效实际调度数 |         否         |      是      |
|           管理开销 |         小         |     较大     |

#### 多线程模型

| 用户线程与内核级线程 | 优点           | 缺点           |
| -------------------: | :------------- | :------------- |
|               多对一 | 线程管理开销小 | 并发不高       |
|               一对一 | 并发高         | 线程管理成本高 |
|               多对多 |                |                |

### 调度

```mermaid
flowchart TD
    style create fill:LightGray,stroke:Blue;
    style stop fill:LightGray,stroke:Blue;
    style running fill:SpringGreen,stroke:Blue;
    style block fill:OrangeRed,stroke:Blue;
    style ready fill:Yellow,stroke:Blue;
    style readyHang fill:LightSkyBlue,stroke:Blue;
    style blockHang fill:LightSkyBlue,stroke:Blue;
    create([创建态]);
    ready([就绪态]);
    running([运行态]);
    stop([终止态]);
    block([阻塞态]);
    readyHang([就绪挂起]);
    blockHang([阻塞挂起]);

    create-->ready<===>running-->stop;

    running-->block-->ready;
    create-->readyHang<==挂起/激活==>ready;
    block<==挂起/激活==>blockHang--事件出现-->readyHang;
    running-->readyHang;
```

| 调度层次 |   方向    | 发生频率 | 状态变化         |                            |
| --------------------: | :-------: | :------: | :--------------- | -------------------------- |
| **高级调度/作业调度** | 外存→内存 |   最低   | 无→创建态→就绪态 | 将外存后备队列作业加入内存 |
| **中级调度/内存调度** | 外存→内存 |   中等   | 挂起态→就绪态    | 将挂起进程数据调回内存     |
| **低级调度/进程调度** | 内存→CPU  |   最高   | 就绪态→运行态    | 为就绪队列分配处理机       |

**调度算法准则**：周转时间短、响应时间快、截止时间保证、优先权准则

**进程调度时机**：主动放弃（异常、IO操作）、被动放弃（时间片耗尽、高优先进程进入就绪队列）

**进程调度方式**：非剥夺调度方式（只允许主动放弃）、剥夺调度方式（抢占式）

#### 调度算法性能指标

$\textnormal{\footnotesize 周转时间} = \textnormal{\footnotesize 作业完成时间} - \textnormal{\footnotesize 作业提交时间}$

$\textnormal{\footnotesize 平均周转时间} = \dfrac{\textnormal{\footnotesize 各作业周转时间之和}}{\textnormal{\footnotesize 作业数}}$

$\textnormal{\footnotesize 带权周转时间} = \dfrac{\textnormal{\footnotesize 作业周转时间}}{\textnormal{\footnotesize 作业实际运行时间}}$

$\textnormal{\footnotesize 平均带权周转时间} = \dfrac{\textnormal{\footnotesize 各作业带权周转时间之和}}{\textnormal{\footnotesize 作业数}}$

$\textnormal{\footnotesize 等待时间} = \textnormal{\footnotesize 作业处于等待处理机状态时间之和}$

$\textnormal{\footnotesize 响应时间} = \textnormal{\footnotesize 从用户提交请求到首次产生响应所用的时间}$

#### 调度算法

>优先级调度算法分为：静态（静态优先权）和动态（高响应比优先）。

|                | FCFS（先来先服务） | SJF（短作业优先） | HRRN（高响应比优先） |
| -------------: | :----------------: | :---------------: | :------------------: |
|       是否抢占 |         否         |      默认否       |          否          |
| 是否会导致饥饿 |         否         |        是         |          否          |
|           缺点 |    对短作业不利    |   对长作业不利    |         折中         |

|                |  时间片轮换  |  优先级调度  | 多级反馈队列 |
| -------------: | :----------: | :----------: | :----------: |
|       是否抢占 |      是      |     均可     |      是      |
| 是否会导致饥饿 |      否      |      是      |      是      |
|           缺点 | 频繁切换开销 | 可能导致饥饿 |     折中     |

### 进程互斥

对**临界资源**的访问，需要互斥进行。即当一个进程进入临界区使用临界资源时，另一个进程必须等待。

```mermaid
graph LR
    style entry fill:LightGray,stroke:Blue;
    style critical fill:OrangeRed,stroke:Blue;
    style exit fill:LightGray,stroke:Blue;
    style remainder fill:LightGray,stroke:Blue;
    entry([进入区])
    -->critical([临界区])
    -->exit([退出区])
    -->remainder([剩余区])
```

#### 互斥原则

- 空闲让进
- 忙则等待：已有其它进程进入临界区时，当前进程试图进入临界区必须等待；
- 有限等待：保证不会饥饿；
- 让权等待：防止进程忙等待；

#### 互斥软件实现方法

```cpp
/**
 * 【单标致法】
 * 说明：每个进程进入临界区的权限只能被另一个进程赋予。
 * 问题：不遵循空闲让进。
 */
int turn = 0;

// P0
while(0 != turn) {  // 进入区
    ...;            // 临界区
    turn = 1;       // 退出区
    ...;            // 剩余区
}

// P1
while(1 != turn) {  // 进入区
    ...;            // 临界区
    turn = 0;       // 退出区
    ...;            // 剩余区
}
```

```cpp
/**
 * 【双标志先检查法】
 * 说明：先检查后上锁，标记每个进程想进入临界区的意愿。
 * 问题：不遵循忙则等待，若按①⑥②⑦③⑧顺序，则两者同时访问临界区。
 */
bool flag[2];
flag[0] = false;
flag[1] = false;

// P0
while(flag[1]) {        // ①进入区，其它进程是否想进入
    flag[0] = true;     // ②进入区，表明自己意愿
    ...;                // ③临界区
    flag[0] = false;    // ④退出区
    ...;                // ⑤剩余区
}

// P1
while(flag[0]) {        // ⑥进入区，其它进程是否想进入
    flag[1] = true;     // ⑦进入区，表明自己意愿
    ...;                // ⑧临界区
    flag[1] = false;    // ⑨退出区
    ...;                // ⑩剩余区
}
```

```cpp
/**
 * 【双标志后检查法】
 * 说明：先上锁后检查。
 * 问题：不遵循空闲让进和有限等待，若按①⑥②⑦顺序，则两者均无法访问临界区。
 */
bool flag[2];
flag[0] = false;
flag[1] = false;

// P0
flag[0] = true;         // ①进入区，表明自己意愿
while(flag[1]) {        // ②进入区，其它进程是否想进入
    ...;                // ③临界区
    flag[0] = false;    // ④退出区
    ...;                // ⑤剩余区
}

// P1
flag[1] = true;         // ⑥进入区，表明自己意愿
while(flag[0]) {        // ⑦进入区，其它进程是否想进入
    ...;                // ⑧临界区
    flag[1] = false;    // ⑨退出区
    ...;                // ⑩剩余区
}
```

```cpp
/**
 * 【Peterson算法】
 * 说明：主动谦让。
 * 问题：不遵循让权等待。
 */
bool flag[2];
flag[0] = false;
flag[1] = false;
int turn = 0;

// P0
flag[0] = true;                 // ①进入区，表明自己意愿
turn = 1                        // ②进入区，主动避让
while(flag[1] && 1 == turn) {   // ③进入区，其它进程是否想进入且当前礼让中
    ...;                        // ④临界区
    flag[0] = false;            // ⑤退出区
    ...;                        // ⑥剩余区
}

// P1
flag[1] = true;                 // ⑦进入区，表明自己意愿
turn = 0                        // ⑧进入区，主动避让
while(flag[0] && 0 == turn) {   // ⑨进入区，其它进程是否想进入且当前礼让中
    ...;                        // ⑩临界区
    flag[1] = false;            // ⑪退出区
    ...;                        // ⑫剩余区
}
```

#### 互斥硬件实现方法

|                | 实现方式         | 优点               | 缺点             |
| -------------: | :--------------- | :----------------- | :--------------- |
|   **中断屏蔽** | 开/关中断指令    | 简单高效           | 只适用于单机处理 |
| **TestAndSet** | 记录、上锁、检查 | 实现简单，多机适用 | 不遵循让权等待   |
|       **Swap** | 记录、上锁、检查 | 实现简单，多机适用 | 不遵循让权等待   |

#### 信号量机制

>软件和硬件互斥方法存在问题：
>1.检查和上锁操作无法一气呵成。
>2.无法实现让权等待。

**原语**：由**关中断**/**开中断**实现，一旦开始执行，就不能被中断的若干条指令。

**PV操作**：一对原语，`wait(S)`和`signal(S)`简称`P(S)`、`V(S)`。

**整型信号量**：

```cpp
int S = 1;          // 初始化整型信号量

void wait(int S) {
    while(S <= 0);  // 资源不够则等待资源
    S--;
}

void signal(int S) {
    S++;
}
```

```cpp
// P0进程
wait(S);        // 申请资源S
...;            // 使用资源S
signal(S);      // 释放资源S
```

**记录型信号量**：为解决**整型信号量**的**忙等待问题**，即**不满足让权等待**问题。

```cpp
typedef struct {
    int value;          // 可用资源数量
    struct process *L;  // 等待进程队列
} semaphore;

void wait(semaphore S) {
    S.value--;
    if(S < 0) block(S.L);           // RUNNING --> BLOCKED
}

void signal(semaphore S) {
    S.value++;
    if(S.value <= 0) wakeup(S.L)    // BLOCKED --> READY
}
```

```cpp
// P0进程
wait(S);        // 申请资源S
...;            // 使用资源S
signal(S);      // 释放资源S
```

#### 管程

用于解决信号量机制编程复杂的问题，包含共享数据结构、数据结构初始化语句、一组用来访问数据结构的过程。

- 外部进程/线程只能通过管程提供特定入口才能访问共享数据
- 每次仅允许一个进程在管程内执行某个内部过程

### 进程同步

一前一后的执行两个操作。

- 初始情况`S = 0`
- 在前操作之和执行`V(S)`
- 在后操作之前执行`P(S)`

<!--问题：生产者消费者问题、吸烟者问题、读者写者问题、哲学家进餐问题 -->

### 死锁

**产生原因**：竞争资源、请求和释放资源的顺序不当

**产生必要条件**：互斥访问、请求和保持、不可抢占、环路等待

#### 死锁的处理

- 预防死锁：破坏**产生的必要条件**
- 避免死锁：银行家算法
- 检测和解除
  - 检测：依次消除资源分配图（进程结点、资源结点、请求边、分配边）中与不阻塞进程相连的边，直到无边可消。
  - 解除：资源剥夺法、撤销进程法、进程回退法
