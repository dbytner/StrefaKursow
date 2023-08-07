package pl.bytner.thread_2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_10 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Long> userIdFuture = CompletableFuture.supplyAsync( () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getUserId();
        });

        userIdFuture.thenCompose( userId -> CompletableFuture.runAsync(() -> {
            getDiscount(userId);
        }));
        executor.shutdown();
    }

    public static Long getUserId(){
        return 32L;
    }

    public static Double getDiscount(Long userId){
        return 0.15;
    }

}
