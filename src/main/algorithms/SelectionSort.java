package main.algorithms;

import main.metrics.PerfomanceTracker;

public class SelectionSort {
    private PerfomanceTracker tracker;

    public SelectionSort(PerfomanceTracker tracker) {
        this.tracker = new PerfomanceTracker();
    }

    public void sort(int[] array) {
        tracker.reset();
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        boolean sorted;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            sorted = true;

            for (int j = i + 1; j < n; j++) {
                tracker.incComparisons();
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }

            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        tracker.incSwap();
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public PerfomanceTracker getTracker() {
        return tracker;
    }
}
