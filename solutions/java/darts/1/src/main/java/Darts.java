import java.util.List;

class Darts {
    
    int score(double xOfDart, double yOfDart) {
        int actualScore = 0;
    	
    	for (Circle circle : circles) {
    		if (circle.isInside(xOfDart, yOfDart)) {
    			actualScore = circle.points;
    			break;
    		}
    	}
    	
        return actualScore;
    }

    public static class Circle {
		
		public Circle(double radiusUnits, int points) {
			this.radiusUnits = radiusUnits;
			this.points = points;
		}
		
		public boolean isInside(double x, double y) {
			return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= radiusUnits;
		}

		public double getRadiusUnits() {
			return radiusUnits;
		}

		public void setRadiusUnits(double radiusUnits) {
			this.radiusUnits = radiusUnits;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}

    	private double radiusUnits;
		private int points;
        
    }

    private Circle inner = new Circle(1, 10);
    private Circle middle = new Circle(5, 5);
    private Circle outer = new Circle(10, 1);
    private List<Circle> circles = List.of(inner, middle, outer);

}
