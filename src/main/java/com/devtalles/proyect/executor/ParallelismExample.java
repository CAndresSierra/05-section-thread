package com.devtalles.proyect.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelismExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Executing newSingleThreadExecutor");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();

        fixedPool.submit(() -> task("Task A"));
        fixedPool.submit(() -> task("Task B"));
        fixedPool.submit(() -> task("Task C"));

        fixedPool.shutdown();

        if(!fixedPool.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("Delayed tasks, force quit");
            fixedPool.shutdown();
        }


        long end = System.currentTimeMillis();

        System.out.println("Total Time: " + (end - start) + " ms");

    }

    public static void task(String name){
        System.out.println("Starting task " + Thread.currentThread().getName());
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("task completed in thread " + Thread.currentThread().getName());
    }
}
