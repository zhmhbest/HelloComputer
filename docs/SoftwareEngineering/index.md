<link rel="stylesheet" href="https://zhmhbest.gitee.io/hellomathematics/style/index.css">
<script src="https://zhmhbest.gitee.io/hellomathematics/style/index.js"></script>

# [软件工程](../index.html)

[TOC]

## 概述

### 软件的定义

软件是计算机系统中与硬件相互依存的另一部分，它包括程序、数据及相关文档的完整集合。其中，程序是按事先设计的功能和性能要求执行的指令序列；数据是使程序能正常操纵信息的数据结构；文档是与程序开发、维护和使用有关的图文材料。

### 软件生存周期与软件过程

- 软件计划与可行性研究（问题定义、可行性研究）
- 需求分析
- 软件设计（概要设计和详细设计）
- 编码
- 软件测试
- 运行与维护

## 软件开发模型（SDLC）

|                                       模型 | 说明                                                         |
| -----------------------------------------: | :----------------------------------------------------------- |
|            瀑布模型<br>（Waterfall Model） | 开发过程是线性的，易于管理，过早的延迟会拖延整个项目，不适合需求模糊的系统 |
| 快速原型模型<br/>（Rapid Prototype Model） | “逼真”的原型可以使用户迅速作出反馈，防止舍不得抛弃           |
|                      V模型<br/>（V Model） | 早期测试介入，每个开发阶段都有一个并行测试阶段               |
|         增量模型<br/>（Incremental Model） | 把待开发的软件系统模块化，可在不知道所有需求的情况下开始开发 |
|              螺旋模型<br/>（Spiral Model） | 快速原型模型+瀑布模型，引入了风险分析，适合于大型复杂的系统  |
|            演化模型<br/>（Fountain Model） | 迭代开发方法，适用于对软件需求缺乏准确认识的情况             |
|            喷泉模型<br/>（Fountain Model） | 描述面向对象的软件开发过程                                   |

## 设计模式

### 软件设计原则（SOLID）

|                                             设计原则 | 说明                                                         |
| ---------------------------------------------------: | :----------------------------------------------------------- |
|  单一职责原则<br>（Single Responsibility Principle） | 一个类应该只有一个发生变化的原因。                           |
|               开闭原则<br/>（Open Closed Principle） | 对扩展开放，对修改关闭。                                     |
|   里氏替换原则<br/>（Liskov Substitution Principle） | 所有引用基类的地方必须能透明地使用其子类的对象。             |
|       迪米特法则/最少知道原则<br/>（Law of Demeter） | 只与你的直接朋友交谈，不跟“陌生人”说话。                     |
| 接口隔离原则<br/>（Interface Segregation Principle） | 客户端不应该依赖它不需要的接口、类间的依赖关系应该建立在最小的接口上。 |
|  依赖倒置原则<br/>（Dependence Inversion Principle） | 上层模块不应该依赖底层模块，它们都应该依赖于抽象、抽象不应该依赖于细节，细节应该依赖于抽象。 |
|       合成复用原则<br/>（Composite Reuse Principle） | 尽量使用对象组合/聚合，而不是继承关系达到软件复用的目的。    |

### 策略模式和模板模式

| 模式 | 说明                                         | 优点                     | 缺点                                               |
| ---: | -------------------------------------------- | :----------------------- | :------------------------------------------------- |
| 策略 | 提供抽象接口，由具体实现类提供不同算法       | 横向扩展性好，灵活性高   | 客户端需要知道全部策略，若策略过多会导致复杂度升高 |
| 模板 | 对同一个算法的不同细节进行抽象提供不同的实现 | 可维护性好，纵向扩展性好 | 耦合性较高，子类无法影响父类公用模块代码           |

### 创建型模式（Creational Pattern）

|             模式 | 说明                                     |
| ---------------: | :--------------------------------------- |
|     **工厂模式** | 创建对象时不会对客户端暴露创建逻辑。     |
| **抽象工厂模式** | 围绕一个超级工厂创建其他工厂。           |
|     **单例模式** | 确保只有单个对象被创建。                 |
|   **建造者模式** | 使用多个简单的对象构建成一个复杂的对象。 |
|     **原型模式** | 创建当前对象的克隆。                     |

```java
public class Main {
    static ArrayList<String> oneObject = new ArrayList<String>() {{
        add("Default");
    }};

    static Object getFactoryInstance() {
        return new ArrayList<String>() {{
            add("Factory");
        }};
    }

    static Object getSingleInstance() {
        return oneObject;
    }

    static Object getPrototypeInstance() {
        return oneObject.clone();
    }

    public static void main(String[] args) {
        // 【工厂模式】
        Object factoryObject = getFactoryInstance();
        System.out.println(factoryObject);

        // 【抽象工厂模式】
        // 略

        // 【单列模式】
        Object singleObject = getSingleInstance();
        System.out.printf("%s %b\n", singleObject, singleObject == getSingleInstance());

        // 【建造者模式】
        StringBuilder builder = new StringBuilder();
        builder.append("Builder");
        System.out.println(builder);

        // 【原型模式】
        Object prototypeObject = getPrototypeInstance();
        System.out.printf("%s %b\n", prototypeObject, prototypeObject == getPrototypeInstance());
    }
}
```

### 结构型模式（Structural Pattern）

适配器模式、装饰者模式、代理模式、外观模式、桥接模式、组合模式、享元模式

### 行为型模式（Behavioral Pattern）

策略模式、模板方法模式、观察者模式、迭代器模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

## 面向对象与UML

泛化、实现、关联、聚合、组合、依赖
泛化关系：面向对象语言中的继承关系
实现关系：继承一个抽象类
组合关系：成员变量
聚合关系：是整体与部分的关系
关联关系：是整体与部分的关系
依赖关系：一个类的实现需要另一个类的协助
