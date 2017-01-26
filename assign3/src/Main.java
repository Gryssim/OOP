import vehicles.*;
import java.util.*;

public class Main extends Object {
  public static void main(String [] args){
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    vehicles.add(new Car(4));
    vehicles.add(new Boat(55));

    Car volt = new Car(4);
    System.out.println(volt.getCapacity());
    System.out.println("Room left in the car: " + volt.getRoomLeft());
    volt.setOccupants(1);
    System.out.println("Room left in the car: " + volt.getRoomLeft());

    for(Vehicle vehicle : vehicles){
      System.out.println("Room left in the vehicle: " + vehicle.getRoomLeft());
    }

  }
}
