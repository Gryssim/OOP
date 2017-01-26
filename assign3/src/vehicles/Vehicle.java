package vehicles;

public class Vehicle{

  private int _capacity;
  private int _occupants;
  private int _roomLeft;

  public int getCapacity() { return _capacity; }
  public void setCapacity(int capacity){
    _capacity = capacity;
  }

  private void _calcRoomLeft(){
    _roomLeft = _capacity - _occupants;
  }

  public int getRoomLeft(){
    _calcRoomLeft();
    return _roomLeft;
  }

  public int getOccupants(){ return _occupants; }
  public void setOccupants(int occupants) {
    _occupants = occupants;
    _calcRoomLeft();
  }

}
