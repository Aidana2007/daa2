package algorithms;

import metrics.PerformanceTrackerInsertionSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 2};
        PerformanceTrackerInsertionSort tracker = new PerformanceTrackerInsertionSort();
        InsertionSort.sort(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3}, arr);
    }
}
