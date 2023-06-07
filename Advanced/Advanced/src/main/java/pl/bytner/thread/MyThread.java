package pl.bytner.thread;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println("Wykownywany wątek: " + Thread.currentThread().getName());
    }
}
