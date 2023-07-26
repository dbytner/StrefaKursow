package pl.bytner.thread_2;

import java.util.concurrent.TimeUnit;

public class App_3 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek aplikacji: " + Thread.currentThread().getName());

        Runnable countdown = () -> {
            System.out.println("Wykonywany wątek (runnable): " + Thread.currentThread().getName());
            for (int i = 1; i <= 10; i++){
                System.out.println(i);
                try {
                    //Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable blastOff = () -> {
            System.out.println("Wykonywany wątek (countdown): " + Thread.currentThread().getName());
            System.out.println("Blast off");
        };
        Thread countdownThread = new Thread(countdown,"My-Runnable-1");
        Thread blastOffThread = new Thread(blastOff, "BlastOff");
        countdownThread.start();

        countdownThread.join();
        blastOffThread.start();
    }
}
