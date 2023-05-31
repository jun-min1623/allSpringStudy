package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolimpl implements ThreadPool {


    @Override
    public long Fixedthreadpool(int threadcnt) {

        long startTime = System.currentTimeMillis();
        ThreadPoolExecutor fixedThread = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadcnt);
        fixedThread.execute(() -> {
            Thread t = Thread.currentThread();
            System.out.println("current thread inside : " + t.getName());

            double sum = 0;
            for (double i = 0; i < 100000000; i++) {
                sum += i;
            }
            System.out.println("FixedThreadPool(" + threadcnt + ") sum: " + sum + "//" + System.currentTimeMillis());
        });

        fixedThread.shutdown();

        while (!fixedThread.isTerminated()) ; // fixed thread pool 끝날때까지 대기
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    @Override
    public void Cachedthreadpool() {
        long startTime = System.currentTimeMillis();
        ExecutorService cachedThread = Executors.newCachedThreadPool();
        cachedThread.execute(()->
        {


        });
    }
}
