package pl.bytner.thread_2;

public class App_1 {

    public static void main(String[] args) {
        System.out.println("Główny wątek aplikacji: " + Thread.currentThread().getName());
        Thread thread = new MyThread("My-Thread-1");
        Thread secondThread = new MyThread("My-Thread-2");

        thread.start();
        secondThread.start();
    }
}
