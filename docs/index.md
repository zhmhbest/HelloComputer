<link rel="stylesheet" href="https://zhmhbest.gitee.io/hellomathematics/style/index.css">
<script src="https://zhmhbest.gitee.io/hellomathematics/style/index.js"></script>

# [Computer Network](https://github.com/zhmhbest/HelloComputerNetwork)

[TOC]

## 概论

![osi-tcpip](images/osi-tcpip.png)

## 物理层

## 数据链路层

## 网络层

## 传输层/运输层

### 概念

#### 协议端口（Port）

能唯一的表示确定主机下某一进程的整数（取值范围$[0,65535]$）。分为**服务端口**（取值范围$[0,49151]$）和**客户端口**（取值范围$[49152,65535]$）。

服务端口又分为**熟知端口**（取值范围$[0,1023]$）和**登记端口**（取值范围$[1024,49151]$）。

客户端口仅在客户进程运行时才动态选择。

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

#### 连接建立

<img src="images/tcp_establish.gif" style="width: 600px"/>

#### 连接释放

<img src="images/tcp_release.gif" style="width: 600px"/>

#### 可靠传输



#### 流量控制

#### 拥塞控制

## 应用层

### DNS

### DHCP

### FTP

### SSH/TELNET

### HTTP

### SMTP/POP3/IMAP

### SNMP
