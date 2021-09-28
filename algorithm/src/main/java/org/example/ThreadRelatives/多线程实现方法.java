package org.example.ThreadRelatives;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class 多线程实现方法 {
    final static int times = 10;

    static class A extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < times; i++) {
                System.out.printf("A-%d\n", i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B implements Runnable {
        // 返回值是 void
        @Override
        public void run() {
            for (int i = 0; i < times; i++) {
                System.out.printf("B-%d\n", i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class C implements Callable {
        // 返回值是 泛型
        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < times; i++) {
                System.out.printf("C-%d\n", i);
                Thread.sleep(10);
            }
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        // 1.继承Thread
        new A().start();
        // 2.实现Runnable
        new Thread(new B()).start();
        // 3.实现Callable
        FutureTask<Integer> task = new FutureTask<Integer>(new C());
        new Thread(task).start();
        // 4.从线程池获取

        for (int i = 0; i < times; i++) {
            System.out.printf("D-%d\n", i);
            Thread.sleep(10);
        }

        // FutureTask + Callable 可以获取线程运行后的返回值
        Integer result = task.get();
        System.out.println(result);
    }
}
