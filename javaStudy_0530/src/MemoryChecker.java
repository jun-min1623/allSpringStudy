import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryChecker {
    public static void main(String[] args) {
        // Print the initial memory usage
        printMemoryUsage();

        // Create a FixedThreadPool with a specific number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Object> arrayList = new ArrayList<>();
        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            try {
                arrayList.add("qwertasdfg12345qwertasdfg12345qwertasdfg12345qwertasdfg12345qwertasdfg12345qwertasdfg12345qwertasdfg12345qwertasdfg12345");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executorService.execute(() -> {
                // Create some objects to consume memory
                int[] array = new int[1000000];
                String[] strings = new String[1000000];
                for (int j = 0; j < 1000000; j++) {
                    strings[j] = new String("String " + j);
                }

                // Print the memory usage after creating objects
                printMemoryUsage();
            });
        }

        // Shutdown the executor service
        executorService.shutdown();
    }

    private static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("Max Memory: " + maxMemory / (1024 * 1024) + " MB");
        System.out.println("Allocated Memory: " + allocatedMemory / (1024 * 1024) + " MB");
        System.out.println("Free Memory: " + freeMemory / (1024 * 1024) + " MB");
        System.out.println("----------------------------------------");
    }
}
