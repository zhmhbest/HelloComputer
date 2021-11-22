
```bash
-cp         目录/zip/jar搜索路径
-classpath  目录/zip/jar搜索路径（可指定多个）

-Xloggc:<file>  将GC状态记录在文件中(带时间戳)
-Xms<size>      初始Heap大小（默认物理内存的1/64）
-Xmx<size>      最大Heap大小（默认物理内存的1/4）
-Xss<size>      每个线程的Heap大小（默认1m）

# 堆大小 = 年轻代大小 + 年老代大小 + 持久代大小
-Xmn<size>                  -XX:newSize=<size> + -XX:MaxnewSize==<size>
-XX:NewSize=<size>          年轻代初始内存（应小于ms）
-XX:MaxnewSize=<size>       年轻代最大内存（应小于mx）
-XX:PermSize=<size>         持久代初始大小
-XX:MaxPermSize=<size>      持久代最大大小
-XX:NewRatio=<size>         年轻代:年老代的比值=1:<size>
```

### 垃圾判断

- 引用计数法
- 可达性分析算法（连通图）

### 垃圾收集算法

- 标记-清除算法（Mark-Sweep）
- 复制算法（Copying）
- 标记-整理算法（Mark-Compact）
- 分代收集算法

### JVM Heap

- 年轻代：MinorGC（Copying算法为主）
- 老年代：MajorGC/FullGC（Mark-Compact算法为主）
- 永久代

### ClassLoader

类加载器（ClassLoader）把Java代码转换成字节码，运行时数据区（Runtime Data Area）再把字节码加载到内存中。

类加载器和这个类本身一同确立其在JVM中的唯一性，每个类加载器，都拥有一个
独⽴的类名称空间。⽐较两个类是否“相等”，只有在这两个类是由同一个类加载器加载的前提下才有意义。

- BootstrapClassLoader：C++语言实现的，JVM自身需要的类，是虚拟机自身的一部分。
- ExtensionClassLoader：负责加载`${JAVA_HOME}/lib/ext`。
- SystemClassLoader：负责加载`${CLASS_PATH}`。
- AppClassLoader：用户自己实现的类加载器。

#### 双亲委派模型

ClassLoader首先不会自己去尝试加载类，而是把这个请求委派给父ClassLoader去完
成。只有当父ClassLoader无法完成这个加载请求（它的搜索范围中没有找到所需的类）时，子ClassLoader才会尝试自己去加载。
