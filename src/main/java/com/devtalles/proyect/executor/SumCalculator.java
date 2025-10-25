package com.devtalles.proyect.executor;

import java.util.concurrent.*;

public class SumCalculator implements Callable<Integer> {
    private final int number1;
    private final int number2;

    public SumCalculator(int number2, int number1) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public Integer call() throws Exception{
        System.out.println("Task: initialising sum.....");

        Thread.sleep(1500);
        int sum = number1 + number2;

        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("Task: completed sum");
        return sum;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> sumTask = new SumCalculator(5, 30);

        Future<Integer> result = executor.submit(sumTask);

        while(!result.isDone()){
            System.out.println("Processing...");
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Result = " + result.get());

        executor.shutdown();
    }

}
