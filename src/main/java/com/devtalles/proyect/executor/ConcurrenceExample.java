package com.devtalles.proyect.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrenceExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Executing newSingleThreadExecutor");
        ExecutorService single = Executors.newSingleThreadExecutor();

        long start = System.currentTimeMillis();

        single.submit(() -> task("Task A"));
        single.submit(() -> task("Task B"));
        single.submit(() -> task("Task C"));

        single.shutdown();

        if(!single.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("Delayed tasks, force quit");
            single.shutdown();
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
