package com.exercices.concurrency.reentrantlock;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(new IncrementTask(counter));
        Thread t2 = new Thread(new WaitForCountTask(counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        Output example:
//        Thread-0 incremented count to: 1
//        Thread-1 waiting for count to reach 3
//        Thread-0 incremented count to: 2
//        Thread-1 waiting for count to reach 3
//        Thread-0 incremented count to: 3
//        Thread-1 retrieved count: 3
//        Thread-0 incremented count to: 4
//        Thread-0 incremented count to: 5
    }
}
