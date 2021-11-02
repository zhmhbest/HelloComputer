
### 发展史

- 电子管
- 晶体管
- 中小规模集成电路
- 大规模集成电路

### 性能指标

**字长**：一次能处理的二进制数据的位数

**时钟频率**：$\textnormal{\footnotesize CPU主频} = \dfrac{1}{\textnormal{\footnotesize CPU时钟周期}}$

**运算速度**：

- **CPI（Clock cycle Per Instruction）**：执行一条指令所需要的时钟周期数。
- **IPS（Instruction Per Second）**：每秒执行多少条指令，$IPS = \dfrac{\textnormal{\footnotesize 主频}}{\textnormal{\footnotesize 平均CPI}}$
- **FLOPS**：每秒执行多少次浮点运算。

**内存容量**：主存大小。

### 冯诺依曼结构

- **五大部分**组成；
- 指令和数据以同等地位存储；
- 指令和数据用**二进制**表示；
- 指令由操作码和地址码组成；
- **存储程序**；
- 以运算器为中心（早期）。

```mermaid
flowchart
    subgraph 早期结构
        style INPUT1 fill: lightgrey, stroke: blue;
        style OUTPUT1 fill: lightgrey, stroke: blue;

        style ARITHMETIC1 fill: OrangeRed;
        style MEMORY1 fill: SandyBrown;
        style CONTROLLER1 fill: LightSkyBlue;

        INPUT1[/输入设备/];
        OUTPUT1[/输出设备/];
        ARITHMETIC1([运算器]);
        MEMORY1([存储器]);
        CONTROLLER1((控制器));

        INPUT1-->ARITHMETIC1-->OUTPUT1;
        ARITHMETIC1<-->MEMORY1-->CONTROLLER1;

        CONTROLLER1<-.->INPUT1;
        CONTROLLER1<-.->OUTPUT1;
        CONTROLLER1<-.->MEMORY1;
        CONTROLLER1<-.->ARITHMETIC1;
    end
    subgraph 现代结构
        style INPUT2 fill: lightgrey, stroke: blue;
        style OUTPUT2 fill: lightgrey, stroke: blue;

        style ARITHMETIC2 fill: OrangeRed;
        style MEMORY2 fill: SandyBrown;
        style CONTROLLER2 fill: LightSkyBlue;

        INPUT2[/输入设备/];
        OUTPUT2[/输出设备/];
        ARITHMETIC2([运算器]);
        MEMORY2([存储器]);
        CONTROLLER2((控制器));

        INPUT2-->MEMORY2-->OUTPUT2;
        MEMORY2<-->ARITHMETIC2;
        MEMORY2-->CONTROLLER2;


        CONTROLLER2<-.->INPUT2;
        CONTROLLER2<-.->OUTPUT2;
        CONTROLLER2<-.->MEMORY2;
        CONTROLLER2<-.->ARITHMETIC2;
    end
```

### 计算机构成

**硬件系统**：主机（CPU、控制器、主存）、外部设备或IO设备（硬盘、键盘、显示器等）

```mermaid
flowchart LR
style INPUT fill: lightgrey, stroke: blue;
style OUTPUT fill: lightgrey, stroke: blue;

style 运算器 fill: OrangeRed;
style 控制器 fill: LightSkyBlue;
style CPU fill: PaleTurquoise;
style 主存储体 fill: SandyBrown;

subgraph 主机
    subgraph CPU
        subgraph 运算器
            style X fill: lightgrey;
            style ALU fill: lightgrey;
            style ACC fill: lightgrey;
            style MQ fill: lightgrey;
            X["x（通用操作数寄存器）"]-->ALU["ALU（算术逻辑单元）"]-->ACC["ACC（累加器）"]-->MQ["MQ（乘商寄存器）"];
            MQ-->ACC-->ALU;
        end
        subgraph 控制器
            style CU fill: lightgrey;
            style IR fill: lightgrey;
            style PC fill: lightgrey;
            CU["CU（控制单元）"];
            IR["IR（指令控制器）"];
            PC["PC（程序计数器）"];
        end
    end
    subgraph 主存储体
        style Storage fill: lightgrey;
        style MAR fill: lightgrey;
        style MDR fill: lightgrey;
        Storage[存储体]
        MAR["MAR（Memory Address Register）"]
        MDR["MDR（Memory Data Register）"]
    end
end
subgraph IO
    INPUT[/输入设备/];
    OUTPUT[/输出设备/];
end
```

**软件系统**：系统软件、应用软件

**计算机层次结构**：

- M4：高级语言
- M3：汇编语言
- M2：操作系统机器（向上提供广义指令）
- M1：传统机器（执行机器语言指令）
- M0：微程序机器（执行微指令）
