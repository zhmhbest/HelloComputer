package org.example.thread;

public class 线程同步 {
    static class OrderedThreads {
        public interface CoreBlock {
            /**
             * @param name 线程名称
             * @param size 循环次数
             * @param prev 前一个线程对象
             * @param self 当前线程对象
             */
            void run(final char name, final int size, final Thread prev, final Thread self) throws InterruptedException;
        }
        public static void start(final int threadSize, final int loopSize, CoreBlock core) throws InterruptedException {
            Thread[] threads = new Thread[threadSize];
            // 创建所有线程
            for (int i = 0; i < threadSize; i++) {
                final int k = i;
                threads[i] = new Thread(() -> {
                    try {
                        core.run((char) ('A' + k), loopSize, threads[(k - 1 + threadSize) % threadSize], threads[k]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            // 启动所有线程
            for (Thread thread : threads) {
                thread.start();
                Thread.sleep(10); // 保证线程依次运行
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OrderedThreads.start(6, 10, (name, size, prev, self) -> {
            int i = 0;
            for (;;) {
                synchronized (prev) {       // prev没有释放，self不会执行
                    synchronized (self) {   // self没有释放，next不会执行
                        System.out.printf("%s-%d\n", name, i);
                        i++;
                        self.notifyAll();   // 唤醒其它竞争self锁的线程（即唤醒next）
                    }
                    if (i < size) {
                        prev.wait();        // 立即释放prev对象锁，同时self休眠等待被prev唤醒
                    } else {
                        prev.notifyAll();
                        break;
                    }
                }
            }
        });
    }
}
