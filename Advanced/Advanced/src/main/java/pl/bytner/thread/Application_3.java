package pl.bytner.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application_3 {

    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable countdown = () -> {
            try {
                System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable blastOff = ()->{
            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
            System.out.println("Blast off!");
        };
        executor.submit(countdown);
        executor.submit(blastOff);

        executor.shutdown();
    }
}
