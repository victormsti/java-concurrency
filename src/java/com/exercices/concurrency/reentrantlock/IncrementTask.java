package com.exercices.concurrency.reentrantlock;

public class IncrementTask implements Runnable {
    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    private final Counter counter;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100); // simulate some work being done
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
