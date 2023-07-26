package pl.bytner.thread_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App_6 {
    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            System.out.println("Robotnik 1 - Aktualny wątek: " + Thread.currentThread().getName());
            System.out.println("Ładuje z butle z tlenem");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker2 = () -> {
            System.out.println("Robotnik 2 - Aktualny wątek: " + Thread.currentThread().getName());
            System.out.println("Ładuje zapas pożywienia");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable worker3 = () -> {
            System.out.println("Robotnik 3 - Aktualny wątek: " + Thread.currentThread().getName());
            System.out.println("Ładuje paliwo");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executor.schedule(worker1, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(worker3, 0, 6, TimeUnit.SECONDS);

        //executor.shutdown();
    }
}
