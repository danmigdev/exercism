import java.util.*;
import java.util.stream.IntStream;

class BirdWatcher {
    
    private final int[] birdsPerDay;
    private static final int BUSY_DAY = 5;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return IntStream.of(birdsPerDay).anyMatch(x -> x == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        return IntStream.of(birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
        return (int) IntStream.of(birdsPerDay).filter(x -> x >= BUSY_DAY).count();
    }
    
}
