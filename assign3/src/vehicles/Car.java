package vehicles;

public class Car extends Vehicle{

  private int _numWheels;

  public Car(int capacity){
    super();
    _numWheels = 4;
    setCapacity(capacity);
    setOccupants(0);
  }

  public int getNumWheels() { return _numWheels; }
  public void setNumWheels(int wheels){
    _numWheels = wheels;
  }
}
