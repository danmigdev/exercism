class NeedForSpeed {

    private int speed;
    private int batteryDrain;
    private int distanceDriven;
    private int battery;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        
        battery = 100;
    }

    public boolean batteryDrained() {
        return battery <= 0;
    }

    public int distanceDriven() {
        return distanceDriven; 
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceDriven += speed;
        }
        
        battery -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
    
}

class RaceTrack {
    
    private int distance;
    
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (!car.batteryDrained()) {
            car.drive();
        }
            
        return car.distanceDriven() >= distance;
    }
    
}
