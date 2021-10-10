package org.example.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestPlus {
    interface PlusAble {
        int number();

        void plus();
    }

    /**
     * 检查子线程是否全部停止
     */
    static void isEnd(Thread[] threads) throws InterruptedException {
        boolean r;
        do {
            r = false;
            Thread.sleep(100);
            for (Thread thread : threads) {
                r = r || thread.isAlive();
            }
        } while (r);
    }

    /**
     * 测试
     */
    static void test(final Class classObject, final int threadSize, final int targetSum) throws InterruptedException, InstantiationException, IllegalAccessException {
        PlusAble plusAble = (PlusAble) classObject.newInstance();
        // 创建、启动全部子线程
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < targetSum; j++) {
                    plusAble.plus();
                }
            });
            threads[i].start();
        }
        // 停止
        isEnd(threads);
        System.out.printf("%s: %d\n", classObject.getName().split("\\$")[1], plusAble.number());
    }

    static void test(final Class classObject) throws InterruptedException, InstantiationException, IllegalAccessException {
        test(classObject, 10, 100);
    }
}

public class 线程互斥 {
    static class AsyncPlus implements TestPlus.PlusAble {
        int index = 0;

        public int number() {
            return index;
        }

        public void plus() {
            index++;
        }
    }

    static class VolatilePlus implements TestPlus.PlusAble {
        volatile int index = 0;

        public int number() {
            return index;
        }

        public void plus() {
            // 包括取值，回写两个步骤
            index = index + 1;
            // volatile仅能保证取值的原子性
        }
    }

    static class SynchronizedMethodPlus implements TestPlus.PlusAble {
        int index = 0;

        public int number() {
            return index;
        }

        public synchronized void plus() {
            index++;
        }
    }

    static class SynchronizedBlockPlus implements TestPlus.PlusAble {
        int index = 0;

        public int number() {
            return index;
        }

        public void plus() {
            synchronized (this) {
                index++;
            }
        }
    }

    static class AtomicPlus implements TestPlus.PlusAble {
        AtomicInteger index = new AtomicInteger();

        public int number() {
            return index.get();
        }

        public void plus() {
            index.getAndIncrement();
        }
    }

    static class LockPlus implements TestPlus.PlusAble {
        int index = 0;
        final Lock lock = new ReentrantLock(); // 定义一个锁

        public int number() {
            return index;
        }

        public void plus() {
            lock.lock(); // 获取锁
            try {
                index++;
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException {
        TestPlus.test(AsyncPlus.class);
        TestPlus.test(VolatilePlus.class);
        TestPlus.test(SynchronizedMethodPlus.class);
        TestPlus.test(SynchronizedBlockPlus.class);
        TestPlus.test(AtomicPlus.class);
        TestPlus.test(LockPlus.class);
    }
}
