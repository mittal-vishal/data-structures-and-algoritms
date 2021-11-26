package com.vishal.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Future {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String > task1 = () -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Task 1 executed");
            return "Task 1 returned";
        };

        Callable<String > task2 = () -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Task 2 executed");
            return "Task 2 returned";
        };

        Callable<String > task3 = () -> {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Task 3 executed");
            return "Task 3 returned";
        };

        ArrayList<Callable<String>> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        try {
            List<java.util.concurrent.Future<String>> list= executor.invokeAll(taskList);
            for(java.util.concurrent.Future<String> f: list){
                try {
                    System.out.println(f.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Main thread running");
            long end = System.currentTimeMillis();
            System.out.println("Total time " + (end - start)/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
