package Figures;

public class Circle extends Figure {
	private double radius;
	Circle(double radius){
		this.setRadius(radius);
		}
	@Override
	public double getS() {
		return Math.PI*radius*radius;
	}
	protected double getRadius() {
		return radius;
	}
	protected void setRadius(double radius) {
		this.radius = radius;
	}

}
