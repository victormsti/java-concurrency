package com.exercices.concurrency.executorservice;

import java.util.concurrent.Callable;

public class Worker implements Callable<Integer> {
    private final Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try{
                Thread.sleep(100); // simulate some work being done
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return counter.getCount();
    }
}
