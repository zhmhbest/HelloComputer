
### 概念

#### 协议端口（Port）

能唯一的表示确定主机下某一进程的整数（取值范围$[0,65535]$）。分为**服务端口**（取值范围$[0,49151]$）和**客户端口**（取值范围$[49152,65535]$）。

服务端口又分为**熟知端口**（取值范围$[0,1023]$）和**登记端口**（取值范围$[1024,49151]$）。

客户端口仅在客户进程运行时才动态选择（**动态端口**）。

#### 套接字（Socket）

网络中不同主机上的应用进程之间进行双向通信的端点的抽象。

$$Socket = (Host, Port)$$

### UDP

- 无连接
- 尽最大努力交付
- 面向报文
- 没有拥塞控制
- 首部开销小（8个Bytes）

#### UDP数据报

@import "tables/udp1.html"

#### UDP伪首部

@import "tables/udp2.html"

### TCP

- 面向连接
- 点对点通信
- 提供可靠交付
- 全双工通信
- 面向字节流

#### TCP首部

@import "tables/tcp.html"

- URG：紧急比特
- ACK：确认比特
- PSH：推送比特
- RST：复位比特
- SYN：同步比特
- FIN：终止比特

#### 连接建立

<img src="images/tcp_establish.gif" style="width: 600px"/>

- $→ SYN=1,seq=x$
- $← SYN=1,ACK=1,seq=y,ack=x+1$
- $→ ACK=1,seq=x+1,ack=y+1$

#### 连接释放

<img src="images/tcp_release.gif" style="width: 600px"/>

- $→ FIN=1,seq=u$
- $← ACK=1,seq=v,ack=u+1$
- $← FIN=1,ACK=1,seq=w,ack=u+1$
- $→ ACK=1,seq=u+1,ack=w+1$

#### 可靠传输

- 超时重传（超时时间根据加权平均往返时间）
- 冗余ACK重传

#### 流量控制

- 滑动窗口（动态调整窗口大小）
- 零窗口通知计时器

#### 拥塞控制

- 满开始、拥塞避免

<img src="images/congestion_0.png" style="width: 600px"/>

- 快重传、快恢复

<img src="images/congestion_1.png" style="width: 600px"/>
