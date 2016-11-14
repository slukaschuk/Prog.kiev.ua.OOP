package Cars;

public class MyClass {

    public static void main(String[] args) {
        try {
            Car bmw = new Car("BMW");
            Car ferrari = new Car("Ferrari", 20000, 3.0);
            
            bmw.turnOn();
            ferrari.turnOn();
            
            int[] speeds = new int[] {20, 60, 100};
            
            for (int s : speeds)
                bmw.start(s, 0.5);
            for (int s : speeds)
                ferrari.start(s, 1);
            
            bmw.turnOff();
            ferrari.turnOff();
            
            System.out.println("Cars count: " + Car.count);
            System.out.println(bmw.getName() + ": " + bmw.getMileage());
            System.out.println(ferrari.getName() + ": " + ferrari.getMileage());
            
            System.out.println(bmw.getName() + ": " + bmw.getFuel());
            System.out.println(ferrari.getName() + ": " + ferrari.getFuel());

        } catch (Exception ex) {
            System.out.println("Error!");
        }
    }
}
