package com.devtalles.proyect.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownComparison {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++){
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Starting task with executor: " + taskId + " " + Thread.currentThread().getName());

                try{
                    Thread.sleep(4000);
                } catch (InterruptedException e){
                    System.out.println("Task " + taskId + " has been interrupted");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {}
                    return;
                }

                System.out.println("Task completed");
            });
        }

        Thread.sleep(5000);

        boolean error = true;

        if(error){
            System.out.println("Critical situation");
            executor.shutdownNow();
        } else {
            System.out.println("Ordered finalization");
            executor.shutdown();
        }

        if(executor.awaitTermination(2, TimeUnit.SECONDS)){
            System.out.println("tasks completed successfully");
        } else {
            System.out.println("tasks not completed correctly");
        }


    }
}
