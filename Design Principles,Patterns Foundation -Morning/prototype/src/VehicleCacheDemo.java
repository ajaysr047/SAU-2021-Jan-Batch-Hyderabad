import java.util.Hashtable;

public class VehicleCacheDemo {
    private static Hashtable<Integer, Vehicle> vehicleHashtable = new Hashtable<>();

    public static Vehicle getVehicle(Integer vehicleId){
        Vehicle vehicle = vehicleHashtable.get(vehicleId);
        return (Vehicle) vehicle.clone();
    }

    public static void loadCache(){
        Car car = new Car();
        Bike bike = new Bike();
        Truck truck = new Truck();

        vehicleHashtable.put(car.getVehicleId(), car);
        vehicleHashtable.put(bike.getVehicleId(), bike);
        vehicleHashtable.put(truck.getVehicleId(), truck);
    }

    public static void main(String[] args) {
        loadCache();

        Vehicle clonedBike =  getVehicle(1);
        Vehicle clonedCar =  getVehicle(2);
        Vehicle clonedTruck =  getVehicle(2);

        System.out.println("Cloned vehicle type: " + clonedBike.getType());
        System.out.println("Cloned vehicle type: " + clonedCar.getType());
        System.out.println("Cloned vehicle type: " + clonedTruck.getType());
    }
}
