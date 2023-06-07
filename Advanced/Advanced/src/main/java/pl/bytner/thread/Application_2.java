package pl.bytner.thread;

import java.util.concurrent.TimeUnit;

public class Application_2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek aplikacji " + Thread.currentThread().getName());

        Runnable countdown = () -> {
            try {
                System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable blastOff = ()->{
            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
            System.out.println("Blast off!");
        };

        Thread countdownThread = new Thread(countdown, "Countdowns");

        Thread blastOffThread = new Thread(blastOff, "Blast Off");
        countdownThread.start();

        countdownThread.join();

        blastOffThread.start();
    }
}
