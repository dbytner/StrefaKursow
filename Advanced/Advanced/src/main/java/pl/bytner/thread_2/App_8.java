package pl.bytner.thread_2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App_8 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };
        Callable<Integer> anotherAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(13);
            return 43;
        };
        Callable<Integer> finalAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 44;
        };

        List<Callable<Integer>> callableList = Arrays.asList(answerToEverything, anotherAnswerToEverything, finalAnswerToEverything);

        List<Future<Integer>> futures = executor.invokeAll(callableList);
        for (Future<Integer> f : futures){
            System.out.println(f.get());
        }

        executor.shutdown();

    }
}
