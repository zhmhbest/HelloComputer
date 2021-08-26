
### DNS

### DHCP

### FTP

### SSH/TELNET

### HTTP/HTTPS

#### http和https的区别

| 区别 | http | https |
| - | - | - |
| 默认端口 | 80 | 443 |
| 有无证书 | 无 | 需要CA证书（付费） |
| 是否加密 | 无 | SSL加密 |
| 建立连接 | 交换3个包 | 交换3+9个包 |
| 资源消耗 |  | 较http多 |
| 安全性 | 无 | 安全 |

#### http1.0和http1.1的区别

| 区别 | http1.0 | http1.1 |
| - | - | - |
| 缓存处理 | `If-Modified-Since`、`Expires` | `Entity tag`、`ExIf-Unmodified-Sincepires`、`If-Match`、`If-None-Match`等更多缓存控制策略 |
| 默认连接 | 短连接 | 长连接：`Connection: keep-alive` |
| 带宽优化 | | 请求资源的部分：`206` + `Range: bytes=start-end` |
| 状态码 | | 新增24个错误状态响应码 |
| 头信息 | | 支持Host头域指明主机 |

#### 从输入URL到页面展示

1. DNS解析
2. 建立连接（构建在TCP之上的HTTP协议）
3. HTTP请求（请求行、请求头、请求体）
4. 服务端：接受请求数据、生成要返回的数据
5. HTTP响应（响应行、响应头、响应体）
6. 浏览器渲染页面

### SMTP/POP3/IMAP

### SNMP
