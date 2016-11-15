package Figures;

public class Triangle extends Figure{
    protected double a; 
    protected double b;
    protected double c;
    protected double h;
    
    Triangle(double a, double b, double c, double h){
    	this.a = a;
    	this.b = b;
    	this.c = c;
    	this.h = h;
    }
	@Override
	public double getS() {
		
		return 0.5*a*h;
	}

}
