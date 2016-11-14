package Cars;

public class Car {

    static public int count = 0;
    
    protected String name;
    protected Engine engine;
    
    private double fuel;
    
    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 2.0);
        count++;
    }
    
    public Car(String name, double mileage, double volume) {
        this.name = name;
        engine = new Engine(mileage, volume);
        count++;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMileage() {
        return engine.getMileage();
    }
    
    public void turnOn() {
        engine.turnOn();
    }
    
    public void turnOff() {
        engine.turnOff();
    }
    
    public double getFuel() {
    	return fuel;
    }
    
    public void start(int speed, double hours) {
        if ( ! engine.isStarted())
            return;
    
        double distance = hours * speed;
        engine.addMileage(distance);
        
        double f = (distance / 100) * Engine.getCons(engine.getVolume());
        fuel += f;
    }
}