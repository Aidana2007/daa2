package main.java.algorithms;

import main.java.metrics.PerformanceTrackerInsertionSort;

public class InsertionSort {

    public static void sort(int[] arr, PerformanceTrackerInsertionSort tracker) {
        if (arr == null) throw new IllegalArgumentException("Array cannot be null");
        if (arr.length <= 1) return;

        tracker.start();
        boolean sorted = true;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            tracker.addArrayAccess(1);

            tracker.addComparison();
            if (arr[i - 1] <= key) continue;
            sorted = false;

            int insertPos = binarySearch(arr, key, 0, i - 1, tracker);

            int j = i - 1;
            while (j >= insertPos) {
                arr[j + 1] = arr[j];
                tracker.addArrayAccess(2);
                j--;
            }
            arr[insertPos] = key;
            tracker.addArrayAccess(1);
            tracker.addSwap();
        }

        tracker.stop();

        if (sorted) {
            System.out.println("Array was already nearly sorted — optimized path triggered.");
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high, PerformanceTrackerInsertionSort tracker) {
        while (low <= high) {
            int mid = (low + high) / 2;
            tracker.addArrayAccess(1);
            tracker.addComparison();
            if (arr[mid] == key)
                return mid + 1;
            tracker.addComparison();
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
