package com.devtalles.proyect.scheduletasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    public static void main(String[] args) {
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//
//        executorService.schedule(() -> {
//            System.out.println("Task after 4 seconds.");
//        }, 4, TimeUnit.SECONDS);
//
//        executorService.schedule(() -> {
//            System.out.println("Task after 5 seconds.");
//        }, 5, TimeUnit.SECONDS);
//        executorService.shutdown();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                System.out.println("Sending reminders...");
                counter++;
                if(counter > 3){
                    System.out.println("All reminders has been sent");
                    executor.shutdown();
                }
            }
        };

        executor.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);

    }
}
