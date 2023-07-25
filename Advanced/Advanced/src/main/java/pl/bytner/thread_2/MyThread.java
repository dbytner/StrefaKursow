package pl.bytner.thread_2;

import java.util.stream.IntStream;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
            System.out.println("Wykonywany wątek: " + Thread.currentThread().getName());
    }
}
