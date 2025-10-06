package main.cli;

import main.algorithms.SelectionSort;
import main.metrics.PerfomanceTracker;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SelectionSortBenchmark {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000};
        String[] types = {"RANDOM", "SORTED", "REVERSE_SORTED"};

        try (FileWriter writer = new FileWriter("selection_sort_results.csv")) {
            writer.write("algorithm,n,arrayType,comparisons,swaps,timeMs\n");

            for (int size : sizes) {
                for (String type : types) {
                    runTest(size, type, writer);
                }
            }
        }
    }

    private static void runTest(int n, String type, FileWriter writer) throws IOException {
        int[] array = generateArray(n, type);
        SelectionSort sorter = new SelectionSort();

        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();

        PerfomanceTracker tracker = sorter.getTracker();
        double timeMs = (endTime - startTime) / 1_000_000.0;

        writer.write(String.format("SELECTION,%d,%s,%d,%d,%.3f\n",
                n, type, tracker.getComparisons(), tracker.getSwaps(), timeMs));

        System.out.printf("SELECTION n=%-6d %-15s comparisons=%-8d swaps=%-6d time=%.3f ms\n",
                n, type, tracker.getComparisons(), tracker.getSwaps(), timeMs);
    }

    private static int[] generateArray(int n, String type) {
        Random rand = new Random(42);
        int[] arr = new int[n];

        switch (type) {
            case "RANDOM":
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(n * 10);
                }
                break;

            case "SORTED":
                for (int i = 0; i < n; i++) {
                    arr[i] = i;
                }
                break;

            case "REVERSE_SORTED":
                for (int i = 0; i < n; i++) {
                    arr[i] = n - i;
                }
                break;
        }
        return arr;
    }
}