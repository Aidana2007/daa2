package test;

import main.algorithms.SelectionSort;
import main.metrics.PerfomanceTracker;

public class SelectionSortTest {
    private SelectionSort selectionSort;
    private PerfomanceTracker tracker;

    public static void main(String[] args) {
        SelectionSortTest test = new SelectionSortTest();
        test.runAllTests();
    }

    public void runAllTests() {
        System.out.println("\nTesting SelectionSort");

        int passed = 0;
        int total = 0;

        try {
            if (testEmptyArray()) {
                passed++;
            }
            total++;
            if (testSingleElement()) {
                passed++;
            }
            total++;
            if (testAlreadySorted()) {
                passed++;
            }
            total++;
            if (testReverseSorted()) {
                passed++;
            }
            total++;
            if (testArrayWithDuplicates()) {
                passed++;
            }
            total++;

        } catch (Exception e) {
            System.out.println("\nTest failed: " + e.getMessage());
        }

        System.out.println("\nTest result: " + passed + " out of " + total);
    }

    private void setUp() {
        selectionSort = new SelectionSort();
        tracker = selectionSort.getTracker();
        tracker.reset();
    }

    private boolean testEmptyArray() {
        try {
            setUp();
            System.out.println("\nTesting empty array");
            int[] arr = {};
            selectionSort.sort(arr);
            boolean passed = arraysEqual(new int[]{}, arr);

            tracker = selectionSort.getTracker();
            passed = passed && (tracker.getComparisons() == 0);
            passed = passed && (tracker.getSwaps() == 0);

            System.out.println(passed ? "PASS" : "FAIL");
            return passed;
        } catch (Exception e) {
            System.out.println("FAIL - Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean testSingleElement() {
        try {
            setUp();
            System.out.print("Testing single element array... ");
            int[] array = {42};
            selectionSort.sort(array);
            boolean passed = arraysEqual(new int[]{42}, array);

            tracker = selectionSort.getTracker();
            passed = passed && (tracker.getComparisons() == 0);
            passed = passed && (tracker.getSwaps() == 0);

            System.out.println(passed ? "PASS" : "FAIL");
            return passed;
        } catch (Exception e) {
            System.out.println("FAIL - Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean testAlreadySorted() {
        try {
            setUp();
            System.out.print("Testing already sorted array (early termination)... ");
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            selectionSort.sort(array);
            boolean passed = arraysEqual(expected, array);

            tracker = selectionSort.getTracker();
            passed = passed && (tracker.getComparisons() == 45);
            passed = passed && (tracker.getSwaps() == 0);

            System.out.println(passed ? "PASS" : "FAIL");
            return passed;
        } catch (Exception e) {
            System.out.println("FAIL - Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean testReverseSorted() {
        try {
            setUp();
            System.out.print("Testing reverse sorted array (worst case)... ");
            int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            selectionSort.sort(array);
            boolean passed = arraysEqual(expected, array);

            tracker = selectionSort.getTracker();
            passed = passed && (tracker.getComparisons() == 45);
            passed = passed && (tracker.getSwaps() <= 9);

            System.out.println(passed ? "PASS" : "FAIL");
            return passed;
        } catch (Exception e) {
            System.out.println("FAIL - Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean testArrayWithDuplicates() {
        try {
            setUp();
            System.out.print("Testing array with duplicates... ");
            int[] array = {5, 2, 8, 2, 5, 1, 8};
            int[] expected = {1, 2, 2, 5, 5, 8, 8};

            selectionSort.sort(array);
            boolean passed = arraysEqual(expected, array);

            tracker = selectionSort.getTracker();
            passed = passed && (tracker.getComparisons() > 0);
            passed = passed && (tracker.getSwaps() > 0);

            System.out.println(passed ? "PASS" : "FAIL");
            return passed;
        } catch (Exception e) {
            System.out.println("FAIL - Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}