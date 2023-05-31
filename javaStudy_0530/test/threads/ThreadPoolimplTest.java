package threads;

import static org.junit.jupiter.api.Assertions.*;

class ThreadPoolimplTest {
    private final ThreadPool threadPool = new ThreadPoolimpl();

    @org.junit.jupiter.api.Test
    void fixedthreadpool() {
        try {
            System.out.println("FixedThreadPool(1) running time: " + threadPool.Fixedthreadpool(1) + "ms // "+System.currentTimeMillis());
            System.out.println("FixedThreadPool(100) running time: " + threadPool.Fixedthreadpool(100) + "ms//"+System.currentTimeMillis());
        }catch (InterruptedException e){

        }

    }

    @org.junit.jupiter.api.Test
    void cachedthreadpool() {
    }
}