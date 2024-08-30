package com.exercices.concurrency.simpleway;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(); // the shared object

        // setting up multiple threads
        // each thread needs the worker that implements runnable
        Thread t1 = new Thread(new Worker(counter), "Worker-1");
        Thread t2 = new Thread(new Worker(counter), "Worker-2");
        Thread t3 = new Thread(new Worker(counter), "Worker-3");

        t1.start();
        t2.start();
        t3.start();

        // wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + counter.getCount());

//        Output example:
//        Worker-1 incremented count to: 1
//        Worker-3 incremented count to: 2
//        Worker-2 incremented count to: 3
//        Worker-1 incremented count to: 4
//        Worker-3 incremented count to: 5
//        Worker-2 incremented count to: 6
//        Worker-1 incremented count to: 7
//        Worker-3 incremented count to: 8
//        Worker-2 incremented count to: 9
//        Worker-1 incremented count to: 10
//        Worker-3 incremented count to: 11
//        Worker-2 incremented count to: 12
//        Worker-1 incremented count to: 13
//        Worker-2 incremented count to: 14
//        Worker-3 incremented count to: 15
//        Final count: 15
    }
}
