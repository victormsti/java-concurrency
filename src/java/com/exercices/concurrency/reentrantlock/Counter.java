package com.exercices.concurrency.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
            condition.signalAll(); // signal other threads waiting on this condition
        } finally {
            lock.unlock();
        }
    }

    public void waitForThreshold(int threshold) {
        lock.lock();
        try{
            while (count < threshold) {
                System.out.println(Thread.currentThread().getName() + " waiting for count to reach " + threshold);
                condition.await(); // wait until signed
            }
            System.out.println(Thread.currentThread().getName() + " retrieved count: " + count);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
