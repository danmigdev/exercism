public class ElonsToyCar {

    private int meters;
    private int battery = 100;
    
    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", meters);
    }

    public String batteryDisplay() {
        return String.format("Battery %s", battery == 0 ? "empty" : "at " + battery + "%");
    }

    public void drive() {
        if (battery > 0) {
            meters += 20;
            battery--;
        }
    }
    
}
