package com.exercices.concurrency.simpleway;

class Counter {
    private int count = 0;

    public void increment(){
        synchronized (this) { // synchronized block to increment the counter
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        }
    }

    public int getCount(){
        return count;
    }
}