import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlightRecorderExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // Generate some workload
        for (int i = 0; i < 100000; i++) {
            numbers.add(i);
        }

        // Start profiling
        startProfiling();

        // Perform some operations using a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int number : numbers) {
            executorService.execute(() -> processNumber(number));
        }
        executorService.shutdown();

        // Wait for all tasks to complete
        while (!executorService.isTerminated()) {
            // Do nothing
        }

        // Stop profiling
        stopProfiling();
    }

    private static void processNumber(int number) {
        // Perform some processing on the number
    }

    private static void startProfiling() {
        // Code to start profiling using Flight Recorder
        // This could involve using JVM flags or a profiler library
        // Refer to your specific profiler's documentation for details
    }

    private static void stopProfiling() {
        // Code to stop profiling and generate the flame graph
        // This could involve saving the profiling data or stopping the profiler
        // Again, refer to your specific profiler's documentation for details
    }
}
