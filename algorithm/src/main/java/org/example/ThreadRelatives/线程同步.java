package org.example.ThreadRelatives;

public class 线程同步 {

    static class Speaker implements Runnable {
        protected Speaker prev;
        protected String speech;

        public Speaker(String speech) {
            this.speech = speech;
        }

        public void loadCompetitors(Speaker[] speakers, int i) {
            int prevIndex = (i - 1 + speakers.length) % speakers.length;
            this.prev = speakers[prevIndex];
        }

        @Override
        public void run() {
            final int times = 100;
            for (int i = 0; ; ) {
                synchronized (prev) { // 保证self一定是在prev操作完成后（即前一个线程释放了其对应的对象锁）

                    synchronized (this) { // 保证后一个对象不能在当前对象执行期间执行
                        System.out.println(speech);
                        i++;
                        this.notifyAll(); // 唤醒其它竞争self锁的线程（即唤醒next）
                    }

                    if (i < times) {
                        try {
                            prev.wait(); // 立即释放prev对象锁，同时本线程休眠
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        prev.notifyAll();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Speaker[] speakers = {
                new Speaker("A"),
                new Speaker("B"),
                new Speaker("C"),
                new Speaker("D"),
                new Speaker("E")
        };
        for (int i = 0; i < speakers.length; i++) {
            speakers[i].loadCompetitors(speakers, i);
        }
        for (Speaker speaker : speakers) {
            new Thread(speaker).start();
            Thread.sleep(10);
        }
    }
}
