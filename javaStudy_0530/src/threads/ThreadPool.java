package threads;

public interface ThreadPool {
    long Fixedthreadpool(int threadcnt) throws InterruptedException;
    void Cachedthreadpool();
}
