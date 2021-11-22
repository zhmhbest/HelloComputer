
### 重载和重写

- 重载（Overload）：编译时多态。
- 重写（Override）：运行时多态，**静态方法**和**私有方法**不能被重写。

```java
public class Main {
    static class Parent {
        void say(int n) { System.out.printf("P say: %d\n", n); }
        void say(String s) { System.out.printf("P say: %s\n", s); }
        static void staticMethod() {}
        private void privateMethod() {}
    }

    static class Child extends Parent {
        @Override
        void say(int n) { System.out.printf("C say: %d\n", n); }
        @Override
        void say(String s) { System.out.printf("C say: %s\n", s); }
        // @Override // 强制重写父类 静态方法 报错
        static void staticMethod() {}
        // @Override // 强制重写父类 私有方法 报错
        private void privateMethod() {}
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.say("Hello");
        child.say(3);
    }
}
```

### 创建对象

- `new`
- `Class.forName(?).newInstance()`
- `Class.forName(?).getDeclaredConstructor(?.class).newInstance(?)`
- `clone()`
- `writeObject(?)`、`readObject()`

```java
import java.io.*;
import java.lang.reflect.Constructor;

public class Main {
    static class People implements Cloneable, Serializable {
        protected String name;
        protected int age;
        public People() { this.name = "None"; this.age = -1; }
        public People(String name, int age) { this.name = name; this.age = age; }
        public void say() { System.out.printf("%s is %d years old.\n", this.name, this.age); }
        @Override
        public People clone() {
            try {
                return (People) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // 1. new
        People p1 = new People("First", 10);
        p1.say();

        // 2. Class.newInstance
        final String className = "Main$People";
        final Class<?> peopleClass = Class.forName(className);
        People p2 = (People) peopleClass.newInstance();
        p2.say();

        // 3. Constructor.newInstance
        Constructor<?> peopleConstructor = peopleClass.getDeclaredConstructor(String.class, int.class);
        People p3 = (People) peopleConstructor.newInstance("Third", 30);
        p3.say();

        // 4. clone
        People p41 = new People("Fourth", 40);
        People p42 = p41.clone();
        System.out.println(p41 == p42);
        p42.say();

        // 5. Serializable
        People p51 = new People("Fifth", 50);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
        // 写
        ObjectOutputStream objO = new ObjectOutputStream(buffer);
        objO.writeObject(p51);
        objO.close();
        // 读
        ObjectInputStream objI = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        People p52 = (People) objI.readObject();
        objI.close();
        // 看
        System.out.println(p51 == p52);
        p52.say();
    }
}
```

#### 反射

- 动态加载，提高代码灵活性。
- 反射操作的效率低于非反射操作。
- 反射技术要求程序必须在一个没有安全限制的环境中运行。
- 反射允许代码执行一些在正常情况下不被允许的操作，破坏了抽象性。

### 接口和抽象类

```java
public class Main {
    interface MyInterface {
        // 常量定义
        double PI = 3.1415926;
        // 抽象方法
        void say();
        // 静态方法（1.8+）
        static void sayHello() { System.out.println("Hello"); }
        // 默认方法（1.8+）
        default void sayName() { System.out.println("My name is Undefined"); }
    }

    abstract static class MyAbstract {
        // 常量定义
        final double PI = 3.1415926;
        // 抽象方法
        public abstract void say();
        // 静态代码块
        static { System.out.println("static block"); }
        // 静态方法
        public static void sayHello() { System.out.println("Hello"); }
        // 成员变量
        protected String name;
        // 构造函数
        public MyAbstract(String name) { this.name = name; }
        // 成员方法
        public void sayName() { System.out.printf("My name is %s\n", this.name); }
    }
}
```

### 装箱和拆箱

```java
public class Main {
    static void autoWrapper(Integer num) {
        System.out.printf("Integer %d\n", num);
    }

    static void autoWrapper(long num) {
        System.out.printf("long %d\n", num);
    }

    public static void main(String[] args) {
        // 扩展优先包装
        int i = 123;
        autoWrapper(i);
        // long 123

        // 原始包装
        Integer j = i;
        autoWrapper(j);
        // Integer 123
    }
}
```

### 类型擦除

```java
List<String> list1 = new ArrayList<String>();

// 泛型信息只存在于代码编译阶段
// 在进⼊JVM之前，与泛型相关的信息会被擦除
// 即后一个<String>没有起到任何作用

List<String> list2 = new ArrayList<>();
```
