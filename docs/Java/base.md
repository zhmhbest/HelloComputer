
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

使用`Class.forName("com.mysql.jdbc.Driver")`这种方式来控制类的加载。反射可以加载在编译时不存在的类。`Class`和`java.lang.reflect`一起对反射提供了支持。

**反射的优点**：

- 动态加载，提高代码灵活性。

**反射的缺点**：

- 性能开销：反射操作的效率低于非反射操作。
- 安全限制：反射技术要求程序必须在一个没有安全限制的环境中运行。
- 内部暴露：反射允许代码执行一些在正常情况下不被允许的操作，破坏了抽象性。

### 动态代理

可以用于**加事务**、**加权限**、**加日志**。

创建代理`Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handle)`

- `loader`：选择由哪个对象来生成代理对象的加载。
- `interfaces`：代理对象的调用接口。
- `handle`：实现了`InvocationHandler`的对象。

实现`InvocationHandler`接口，重写`Object invoke(Object proxy, Method method, Object[] args) throws Throwable`方法。

- `proxy`：代理的真实对象
- `method`：所要调用的该对象的方法
- `args`：调用该方法时传递的参数

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    interface Speaker {
        void sayHello();
        void makeSpeech(String s);
        void sayBye();
    }

    static class User implements Speaker {
        protected String name;
        public User(String name) { this.name = name; }
        @Override
        public void sayHello() { System.out.printf("%s: Hello\n", this.name); }
        @Override
        public void makeSpeech(String s) { System.out.printf("%s: %s\n", this.name, s); }
        @Override
        public void sayBye() { System.out.printf("%s: Bye\n", this.name); }
    }

    static <T> T proxyJDK(Object obj, Class<T> cls) {
        final ClassLoader L = Main.class.getClassLoader();
        final Object R = Proxy.newProxyInstance(L, new Class[]{cls}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                final String name = method.getName();
                System.out.printf("↓↓↓↓ Before %12s ↓↓↓↓\n", name);
                Object ret = method.invoke(obj, args); // 实际调用
                System.out.printf("↑↑↑↑ After  %12s ↑↑↑↑\n\n", name);
                return ret;
            }
        });
        return (T) R;
    }

    public static void main(String[] args) {
        Speaker speaker = proxyJDK(new User("Peter"), Speaker.class);
        speaker.sayHello();
        speaker.makeSpeech("发言内容");
        speaker.sayBye();
    }
}
```

### 泛型

#### 泛型通配符

```java
// 接受任何继承自ClassType的类型
List<? extends Number> list1 = new ArrayList<Integer>();

// 接受任何ClassType的父类类型
List<? super Integer> list2 = new ArrayList<Number>();
```

#### 泛型返回

```java
public class Main {
    static <T> T cast(Object obj, Class<T> cls) {
        return (T) obj;
    }
    public static void main(String[] args) {
        String str = cast("ABC", String.class);
        System.out.println(str);
    }
}
```

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

### 字符串

|                                                              | 说明                 |
| -----------------------------------------------------------: | :------------------- |
|                                               `int length()` | 字符串长度           |
|                                    `int indexOf(String str)` | 字串位置             |
|                                     `char charAt(int index)` | 指定位置的字符       |
|                                              `String trim()` | 删去两端空白         |
|                                       `String toLowerCase()` | 转化为小写           |
|                                       `String toUpperCase()` | 转化为大写           |
|                 `String replace(char oldChar, char newChar)` | 字符串替换           |
| `String substring(int beginIndex)`<br>`String substring(int beginIndex, int endIndex)` | 截取子字符串         |
|                               `String[] split(String regex)` | 字符串分割           |
|    `byte[] getBytes()`<br>`byte[] getBytes(Charset charset)` | 返回字节数组         |
|                            `boolean equals(Object anObject)` | 两个字符串值是否相同 |
|                                             `int hashCode()` | Hash值               |

在Collection和Map中，Hash值能降低对象比较次数。

- Hash值相等，对象不一定相等；
- Hash值不同对象一定不相等。

### 取整

|              | 说明     | 例1              | 例2              | 例3              |
| -----------: | :------- | :--------------- | :--------------- | :--------------- |
| `Math.round` | 四舍五入 | `round(-1.6)=-2` | `round(-1.5)=-1` | `round(-1.4)=-1` |
|  `Math.ceil` | 向上取整 | `ceil(-1.6)=-1`  | `ceil(-1.5)=-1`  | `ceil(-1.4)=-1`  |
| `Math.floor` | 向下取整 | `floor(-1.6)=-2` | `floor(-1.5)=-2` | `floor(-1.4)=-2` |
