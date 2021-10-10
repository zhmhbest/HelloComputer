# Thread类相关方法

## 守护线程

指在程序运行的时候在后台提供一种通用**服务的线程**。

若用户线程已经全部退出运行，只剩下守护线程，虚拟机也会退出。

## 基本方法

>**守护线程**：在后台提供一种通用服务的线程，若用户线程已经全部退出运行，只剩下守护线程，则守护线程也会全部退出。

```java
Thread thread = new Thread();

thread.setName("线程名称");
thread.getName();

thread.getId();			// 线程ID
thread.getPriority();	// 线程优先级

// NEW, RUNNABLE, BLOCKED, WAITING, TIME_WAITING, TERMINATED
thread.getState();		// 线程当前状态

thread.start();     	// 启动线程
thread.stop();      	// 中断线程（弃用）
thread.isAlive();		// 线程是否在运行
thread.run();    		// 直接调用方法而不是启动线程

thread.interrupt();		// 设置线程中断信号（但是否中断由实际代码控制）
thread.isInterrupted();	// 获取中断信号

thread.setDaemon(true);	// 设置为守护线程
thread.isDaemon();		// 是否为守护线程
```

## 同步等待相关

`java.lang.Thread`

```java
// 让出CPU（不考虑优先级），不释放锁，进入TIMED_WAITING
public static native void sleep(long millis) throws InterruptedException;

// 让出CPU（让与同级或更高级），不释放锁，进入READY
// 低优先级线程很可能长期无法执行
public static native void yield();

// 让出CPU，释放管程和锁，当前线程进入BLOCKED
// 直到指定的线程运行结束后再执行本线程
public final void join() throws InterruptedException;
```

`java.lang.Object`

```java
// 让出CPU，释放管程和锁，进入WAITING
public final void wait() throws InterruptedException;

// 随机唤醒对象的等待池中的一个线程
public final native void notify();

// 唤醒对象的等待池中的所有线程
public final native void notifyAll();
```
