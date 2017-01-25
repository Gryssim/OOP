package vehicles;

public class Car extends Vehicle{
  private int _capacity;
  private int _occupants;
  private int _roomLeft;
  private int _numWheels;

  public Car(int capacity){
    super();
    _numWheels = 4;
    _capacity = capacity;
    _occupants = 0;
    _roomLeft = capacity;
  }

  public int getNumWheels() { return _numWheels; }
  public void setNumWheels(int wheels){
    _numWheels = wheels;
  }
}
