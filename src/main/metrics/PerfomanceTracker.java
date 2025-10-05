package main.metrics;

public class PerfomanceTracker {
    private long comparisons;
    private long swap;

    public void reset(){
        comparisons = 0;
        swap = 0;
    }

    public void incComparisons(){
        comparisons++;
    }
    public void incSwap(){
        swap++;
    }
    public long getComparisons(){
        return comparisons;
    }
    public long getSwap(){
        return swap;
    }
}
