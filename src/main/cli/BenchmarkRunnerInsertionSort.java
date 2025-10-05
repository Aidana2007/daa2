package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTrackerInsertionSort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunnerInsertionSort {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000};
        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("n,comparisons,swaps,arrayAccesses,timeMs\n");

            for (int n : sizes) {
                int[] arr = generateRandomArray(n);
                PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();

                InsertionSort.sort(arr, tracker);

                writer.write(String.format("%d,%d,%d,%d,%.3f\n",
                        n,
                        tracker.getComparisons(),
                        tracker.getSwaps(),
                        tracker.getArrayAccesses(),
                        tracker.getElapsedMillis()
                ));

                System.out.printf("n=%d -> %s%n", n, tracker);
            }
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }
}
