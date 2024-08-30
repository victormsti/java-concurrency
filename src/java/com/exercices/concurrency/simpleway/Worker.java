package com.exercices.concurrency.simpleway;

public class Worker implements Runnable{
//    we could also do this
//    public class Worker extends Thread{
    private final Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { // each thread increments the count 5 times
            counter.increment();
            try {
                Thread.sleep(100); // simulate some work being done
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
