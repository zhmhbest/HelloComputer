package org.example.thread;

import java.util.concurrent.*;

public class 线程池 {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //
        ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
    }
}
