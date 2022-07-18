import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName());

        ProblemClass problemClass = new ProblemClass();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            service.submit(() -> problemClass.increase());
        }

        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        System.out.println(problemClass.getX());

//        Callable<Integer> task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                return 123;
//            }
//            catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        };
//
//        Future<Integer> future = service.submit(task);
//
//        System.out.println("future done? " + future.isDone());
//
//        Integer result = future.get();
//
//        System.out.println("future done? " + future.isDone());
//        System.out.print("result: " + result);

        service.shutdown();

    }
}
