package pl.bytner.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application5 {
    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Ładuję butle z tlenem");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Ładuję zapas pożywienia");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 - Aktualny wątek: " + Thread.currentThread().getName());
                System.out.println("Ładuję paliwo");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executorService.schedule(worker1, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(worker3,0, 6, TimeUnit.SECONDS);

        //executorService.shutdown();

    }
}
