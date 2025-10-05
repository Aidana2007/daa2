package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(int count) { arrayAccesses += count; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public double getElapsedMillis() {
        return (endTime - startTime) / 1_000_000.0;
    }

    @Override
    public String toString() {
        return String.format(
                "Comparisons: %d, Swaps: %d, Array Accesses: %d, Time (ms): %.3f",
                comparisons, swaps, arrayAccesses, getElapsedMillis()
        );
    }
}
