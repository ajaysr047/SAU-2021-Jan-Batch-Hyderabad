public class Car extends Vehicle{
    public Car(){
        setVehicleId(2);
        setType("Car");
    }
    @Override
    void printInfo() {
        System.out.println("This is a Car!");
    }
}
