package pl.bytner.thread_2;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Wykonywany wątek: " + Thread.currentThread().getName());
    }
}
