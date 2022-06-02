package WorkSheet6;

public class Circle {
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	
	public double compareTo(Circle other) {
		if (this.radius == other.radius)
			return 2*this.radius*Math.PI;
		else if (this.radius > other.radius) 
			return 2*this.radius*Math.PI;
		else
			return 2*other.radius*Math.PI;
	}
}
