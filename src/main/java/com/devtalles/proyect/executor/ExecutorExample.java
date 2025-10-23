package com.devtalles.proyect.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> System.out.println("Task A " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Task B " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Task C " + Thread.currentThread().getName()));
        executor.shutdown();

    }
}
