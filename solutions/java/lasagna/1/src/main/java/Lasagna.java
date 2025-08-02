public class Lasagna {
    private static final int MINUTES_IN_OVEN = 40;
    private static final int MINUTES_PER_LAYER = 2;
    
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven() {
        return MINUTES_IN_OVEN;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int minutesPassedInTheOven) {
        return MINUTES_IN_OVEN - minutesPassedInTheOven;
    }
    
    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int layers) {
        return MINUTES_PER_LAYER * layers;
    }
    
    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int layers, int minutesPassedInTheOven) {
        return preparationTimeInMinutes(layers) + minutesPassedInTheOven;
    }
}
