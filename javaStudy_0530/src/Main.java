import org.junit.platform.commons.logging.LoggerFactory;
import threads.ThreadPool;
import threads.ThreadPoolimpl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.logging.Level;



public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPool threadPool = new ThreadPoolimpl();
        System.out.println("FixedThreadPool(1) running time: " + threadPool.Fixedthreadpool(1) + "ms // "+System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println("FixedThreadPool(100) running time: " + threadPool.Fixedthreadpool(100) + "ms//"+System.currentTimeMillis());

        //        System.out.println("run async");
//        runAsync();
//        System.out.println("supply async");
//        supplyAsync();

//        ExecutorService es = Executors.newFixedThreadPool(10);
//        CompletableFuture.supplyAsync(() -> {
//            logger.log(Level.INFO, "supplyAsync");
//            return "Hello";
//        }, es).thenApplyAsync(s -> {
//            logger.log(Level.INFO, "thenApplyAsync: {0}", s);
//            return s + " world";
//        }, es).thenAcceptAsync(s -> {
//            logger.log(Level.INFO, "thenAccept: {0}", s);
//        }, es).join();
//
//        es.shutdown();
////
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        CompletableFuture.supplyAsync(() -> {
//            logger.log(Level.INFO, "supplyAsync");
//            return "Hello";
//        }, es).thenApplyAsync(s -> {
//            if(true){
//                throw new IllegalArgumentException("exceptionally test2");
//            }
//            logger.log(Level.INFO, "thenApplyAsync: {0}", s);
//            return s + " world";
//        }, es).thenAcceptAsync(s -> {
//            logger.log(Level.INFO, "thenAccept: {0}", s);
//        }, es).handle((result, e) -> {
//            System.out.println("error handle : "+e);
//            return e == null
//                    ? result
//                    : e.getMessage();
//        });
//        ////
//es.shutdown();
    }

    static void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        future.get();
        System.out.println("Thread print: " + Thread.currentThread().getName());
    }
    static void supplyAsync() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        });
        //future.get();
        System.out.println(future.get());
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}
