public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private static final int UNITS_DISTANCE = 20;

    private int distanceTravelled;
    private int victories;
    
    public void drive() {
        distanceTravelled += UNITS_DISTANCE;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
    
}
