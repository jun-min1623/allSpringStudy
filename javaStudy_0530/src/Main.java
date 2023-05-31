import threads.ThreadPool;
import threads.ThreadPoolimpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)  {
        fixedthreadtest();
    }

    public static void fixedthreadtest(){
        try{
            Thread t = Thread.currentThread();
            System.out.println("current thread : "+t.getName());
            ThreadPool threadPool = new ThreadPoolimpl();
            System.out.println("FixedThreadPool(1) running time: " + threadPool.Fixedthreadpool(1) + "ms // "+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("FixedThreadPool(100) running time: " + threadPool.Fixedthreadpool(100) + "ms//"+System.currentTimeMillis());
            Thread.sleep(10000);
            if(!t.isAlive()) System.out.println("main thread dead ! ");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
