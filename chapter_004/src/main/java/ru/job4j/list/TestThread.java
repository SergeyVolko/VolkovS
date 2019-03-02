package ru.job4j.list;

public class TestThread {
    Thread thread1 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread1");
        }
    });

    Thread thread2 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread2");
        }
    });

    void threadStart() throws InterruptedException {
        this.thread1.start();;
        this.thread2.start();
        this.thread1.join();;
        this.thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
       TestThread testThread = new TestThread();
       testThread.threadStart();
    }
}
