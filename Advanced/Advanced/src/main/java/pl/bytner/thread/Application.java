package pl.bytner.thread;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());
        Thread thread = new MyThread("My Thread-1");
        thread.start();


        Runnable runnable = () -> {
            try {
                System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread anotherThread = new Thread(runnable, "My-Runnable-1");
        anotherThread.start();
    }
}
