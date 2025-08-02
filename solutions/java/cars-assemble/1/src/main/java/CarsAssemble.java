public class CarsAssemble {

    private static final int CARS_PER_HOUR = 221;
    
    public double productionRatePerHour(int speed) {
        double productionRate = 0.0;
        
        if (speed < 5) {
            productionRate = CARS_PER_HOUR * speed * 1.0;
        }
        else if (speed < 9) {
            productionRate = CARS_PER_HOUR * speed * 0.9;
        }
        else if (speed < 10) {
            productionRate = CARS_PER_HOUR * speed * 0.8;
        }
        else {
            productionRate = CARS_PER_HOUR * speed * 0.77;
        }

        return productionRate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60.0);
    }
    
}
