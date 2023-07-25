package pl.bytner.thread;

import java.util.concurrent.*;

public class Application6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> answerToEverthing = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        Callable<Integer> anotherAnswerToEverthing = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 43;
        };

        Callable<Integer> finalAnswerToEverthing = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 44;
        };

        Future<Integer> result = executor.submit(answerToEverthing);
        Integer integer = null;
        try {
            integer = result.get(4, TimeUnit.SECONDS);
            System.out.println(integer);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


        executor.shutdown();
    }
}
