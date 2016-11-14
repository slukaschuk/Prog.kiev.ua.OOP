package Cars;

public class Engine {
    
    protected double mileage = 0;
    protected boolean started;
    
    private double volume;
    
    public Engine(double mileage, double volume) {
        this.mileage = mileage;
        this.volume = volume;
    }
    
    public static double getCons(double volume) {
    	if (volume == 2.0)
    		return 10;
    	else if (volume == 3.0)
    		return 15;
    	else if (volume == 4.2)
    		return 18;
    	else
    		return 0; // !!!
    }
    
    public double getVolume() {
    	return volume;
    }
    
    public double getMileage() {
        return mileage;
    }
    
    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }
    
    public boolean isStarted() {
        return started;
    }
    
    public void turnOn() {
        started = true;
    }
    
    public void turnOff() {
        started = false;
    }
}
