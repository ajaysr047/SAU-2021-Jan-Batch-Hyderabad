public class Truck extends Vehicle{
    public Truck(){
        setVehicleId(3);
        setType("Truck");
    }
    @Override
    void printInfo() {
        System.out.println("This is a Truck!");
    }
}
