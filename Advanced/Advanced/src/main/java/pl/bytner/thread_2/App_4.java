package pl.bytner.thread_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App_4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek aplikacji: " + Thread.currentThread().getName());
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable countdown = () -> {
            System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
            for (int i = 1; i <= 10; i++){
                System.out.println(i);
                try {
                    //Thread.sleep(1000);
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable blastOff = () -> {
            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
            System.out.println("Blast off");
        };
        executor.submit(countdown);
        executor.submit(blastOff);

        executor.shutdown();
    }
}
