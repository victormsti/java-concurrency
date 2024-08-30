package com.exercices.concurrency.reentrantlock;

public class WaitForCountTask implements Runnable {
    public WaitForCountTask(Counter counter) {
        this.counter = counter;
    }

    private final Counter counter;

    @Override
    public void run() {
        counter.waitForThreshold(3);
    }
}
