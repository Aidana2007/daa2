package main.metrics;

public class PerfomanceTracker {
    private long comparisons;
    private long arrayAccesses;
    private long swap;
    private long startTime;
    private long endTime;

    public void reset(){
        comparisons = 0;
        swap = 0;
        startTime = 0;
        endTime = 0;
    }

    public void startTimer(){
        startTime = System.nanoTime();
    }
    public void endTimer(){
        endTime = System.nanoTime();
    }
    public long getElapsedTime(){
        return endTime - startTime;
    }
    public void incArrayAccesses(int count){arrayAccesses+=count;}
    public void incComparisons(){
        comparisons++;
    }
    public void incSwap(){
        swap++;
    }
    public long getComparisons(){
        return comparisons;
    }
    public long getArrayAccesses(){ return arrayAccesses; }

    public long getSwaps() {
        return swap;
    }
}
