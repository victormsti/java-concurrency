package com.exercices.concurrency.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(); // shared object
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = executor.submit(new Worker(counter));
        Future<Integer> f2 = executor.submit(new Worker(counter));
        Future<Integer> f3 = executor.submit(new Worker(counter));

        try{
            System.out.println("Final count: " + f1.get() + ", " + f2.get() + ", " + f3.get());
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

//        Output example:
//        pool-1-thread-2 incremented count to: 1
//        pool-1-thread-1 incremented count to: 2
//        pool-1-thread-3 incremented count to: 3
//        pool-1-thread-3 incremented count to: 4
//        pool-1-thread-2 incremented count to: 5
//        pool-1-thread-1 incremented count to: 6
//        pool-1-thread-1 incremented count to: 7
//        pool-1-thread-2 incremented count to: 8
//        pool-1-thread-3 incremented count to: 9
//        pool-1-thread-1 incremented count to: 10
//        pool-1-thread-2 incremented count to: 11
//        pool-1-thread-3 incremented count to: 12
//        pool-1-thread-2 incremented count to: 13
//        pool-1-thread-1 incremented count to: 14
//        pool-1-thread-3 incremented count to: 15
//        Final count: 15, 15, 15
    }

}
