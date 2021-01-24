public class Bike extends Vehicle{
    public Bike(){
        setVehicleId(1);
        setType("Bike");
    }
    @Override
    void printInfo() {
        System.out.println("This is a bike!");
    }
}
