<!-- ### Exception -->

`try-finally`、`try-catch`

```java
// 在try开头的代码块中catch和finally必须保留一个
try {
    System.out.println("try");
} finally {
    System.out.println("finally");
}
try {
    System.out.println("try");
} catch (Exception e) {
    System.out.println(e.getMessage());
}
```

`throw`、`throws`

```java
public static void main(String[] args)
    throws Exception // 表示该方法存在抛出此异常的可能性
{
    // 手动制造异常抛出
    throw new Exception("Exception Message");
}
```

`Exception`、`Error`

```java
public static void main(String[] args) {
    try {
        // 异常
        throw new Exception("Exception");
        // throw new NullPointerException();       // 空指针
        // throw new IndexOutOfBoundsException();  // 下标越界
        // throw new ClassCastException();         // 类型转换异常
        // throw new IllegalArgumentException();   // 不合规的参数
        // throw new FileNotFoundException();      // 文件不存在
        // throw new IOException();                // IO
        // throw new SQLException();               // SQL
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    try {
        // 错误
        throw new Error("Error");
    } catch (Error e) {
        System.out.println(e.getMessage());
    }

    System.out.println("OK");
}
```

- 若`finally`直接`return`，则以`finally`为准
- 若`finally`改变`return`引用的值，则返回值改变
- 若`finally`改变`return`基础变量的值，则返回值不改变

```java
public class Main {
    static int defaultReturn() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("remain");
        return -1;
    }

    static int tryAndFinallyReturn1() {
        try {
            System.out.println("try");
            return 1;
        } finally {
            System.out.println("finally");
            return 3;
        }
        // return -1; // 该语句无法访问
    }

    static int tryAndFinallyReturn2() {
        int r = 0;
        try {
            System.out.println("try");
            r = 1;
            return r;
        } finally {
            System.out.println("finally");
            r = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int[] tryAndFinallyReturn3() {
        int[] r = {0};
        try {
            System.out.println("try");
            r[0] = 1;
            return r;
        } finally {
            System.out.println("finally");
            r[0] = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int catchAndFinallyReturn1() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
        // return -1; // 该语句无法访问
    }

    static int catchAndFinallyReturn2() {
        int r = 0;
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            r = 2;
            return r;
        } finally {
            System.out.println("finally");
            r = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int[] catchAndFinallyReturn3() {
        int[] r = {0};
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            r[0] = 2;
            return r;
        } finally {
            System.out.println("finally");
            r[0] = 3;
        }
        // return -1; // 该语句无法访问
    }

    public static void main(String[] args) {
        System.out.println(defaultReturn());
        // try、catch、finally、remain、-1
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn1());
        // try、finally、3
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn2());
        // try、finally、1
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn3()[0]);
        // try、finally、3
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn1());
        // try、catch、finally、3
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn2());
        // try、catch、finally、2
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn3()[0]);
        // try、catch、finally、3
        System.out.println("--------");
    }
}
```
