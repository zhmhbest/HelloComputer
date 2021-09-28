package org.example.ThreadRelatives;

public class Thread类相关方法 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // State = {NEW, RUNNABLE, BLOCKED, WAITING, TIME_WAITING, TERMINATED}
        System.out.println(thread.getId());
        System.out.println(thread.getState());      // 线程状态 = NEW
        System.out.println(thread.getPriority());   // 返回线程优先级
        System.out.println(thread.isAlive());
        thread.start();     // 启动线程
        System.out.println(thread.isAlive());
        Thread.sleep(2000);
        thread.stop();      // 中断线程
        // thread.run();    // 直接调用方法而不是启动线程
    }
}
