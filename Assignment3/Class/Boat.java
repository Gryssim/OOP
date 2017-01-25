package vehicles;

public class Boat extends Vehicle{

  private int _capacity;
  private int _occupants;
  private int _roomLeft;

  public Boat(int capacity){
    super();
    _capacity = capacity;
    _occupants = 0;
    _roomLeft = capacity;
  }

  public boolean isYacht(){
    if(_capacity > 50){
       return true;
     }
     return false;
  }

}
