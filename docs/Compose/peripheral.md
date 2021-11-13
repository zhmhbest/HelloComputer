
### 常见设备

#### 磁盘

**技术指标**：记录密度、存储容量、平均寻址时间、数据传输率、误码率。

**磁记录方式**：归零制（RZ）、不归零制（NRZ）、“见1就翻”的不归零制（NRZ1）、调相制（PM）、调频制（FM）、改进型调频制（MFM）

#### 显示器

**性能指标**：分辨率、灰度级、刷新率、点距、屏幕尺寸

#### 打印机

**分类**：激光打印机、喷墨打印机

**性能指标**：打印速度、打印分辨率、最大打印尺寸

### IO系统

**IO接口功能**：选址功能、传送命令功能、传送数据功能、反映IO设备工作状态功能

**IO接口类型**：

- 按传送方式：并行、串行
- 按灵活性：可编程、不可编程
- 按通用性：通用接口、专用接口
- 按传送方式：程序型接口、DMA型接口

**主机与IO设备的联系**：IO指令、编址方式、传送方式

**主机与IO设备的传送控制**：程序查询方式、程序中断方式、直接存储器存取DMA方式、IO通道控制方式

#### 中断

**中断提出方式**：人为设置、程序性事故、硬件故障、IO设备、外部事件

**中断处理过程**：中断请求、中断判优、中断响应、中断服务（保护现场、中断服务、回复现场、中断返回）

**中断屏蔽**：单重中断、中断嵌套/多重中断（提前开中断、中断优先级）

#### DMA

DMA与CPU共享内存，DMA与内存交互方法有：

- CPU停止访问内存法：DMA向CPU发送停止信号
- DMA与CPU交替访问：时间片轮流访问
- 周期挪用法：挪用总线占用权几个内存周期