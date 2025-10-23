package com.devtalles.proyect.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Eexecuting task " + Thread.currentThread().getName());
            try{
               Thread.sleep(1500);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("task completed in thread " + Thread.currentThread().getName());
        };

        System.out.println("Executing newFixedThreadPool");
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        for(int i = 0; i <= 5; i++){
            fixedPool.execute(task);
        }
        fixedPool.shutdown();

        System.out.println("Executing newCachedThreadPool");
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for(int i = 0; i <= 5; i++){
            cachedPool.execute(task);
        }
        cachedPool.shutdown();

        System.out.println("Executing newCachedThreadPool");
        ExecutorService single = Executors.newSingleThreadExecutor();

        for(int i = 0; i <= 5; i++){
            single.execute(task);
        }
        single.shutdown();

    }
}
