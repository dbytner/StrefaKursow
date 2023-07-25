package pl.bytner.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Application_8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek: " + Thread.currentThread().getName()), executor
        );
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42;
        });

        System.out.println(result.get());
        executor.shutdown();
    }
}
