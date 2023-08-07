package pl.bytner.thread_2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class App_9 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executor
        );

         CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42;
        }, executor).thenApply(r -> {
             System.out.println("r * 2" + Thread.currentThread().getName());
             return r * 2;
         }).thenApply(r -> {
             System.out.println("r * 2" + Thread.currentThread().getName());
             return r + 1;
         });

        System.out.println(result.get());

        executor.shutdown();

    }
}
