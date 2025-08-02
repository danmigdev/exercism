class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private static final int UNITS_DISTANCE = 10;

    private int distanceTravelled;
    private int numberOfVictories;
    
    public void drive() {
        distanceTravelled += UNITS_DISTANCE;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar car) {
        return Integer.valueOf(this.getNumberOfVictories()).compareTo(Integer.valueOf(car.getNumberOfVictories()));
    }
    
}
