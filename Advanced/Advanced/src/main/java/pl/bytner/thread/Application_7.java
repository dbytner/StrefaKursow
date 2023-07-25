package pl.bytner.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Application_7 {

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

        List<Callable<Integer>> callableList = Arrays.asList(answerToEverthing, anotherAnswerToEverthing, finalAnswerToEverthing);
        List<Future<Integer>> future = executor.invokeAll(callableList);

        for(Future<Integer> f : future){
            System.out.println(f.get());
        }
        executor.shutdown();
    }
}
