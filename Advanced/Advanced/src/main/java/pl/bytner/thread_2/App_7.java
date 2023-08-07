package pl.bytner.thread_2;

import java.util.concurrent.*;

public class App_7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        Future<Integer> result = executor.submit(answerToEverything);


        Integer integer = result.get(4, TimeUnit.SECONDS);

        System.out.println(integer);
        executor.shutdown();

    }
}
