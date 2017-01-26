package vehicles;

public class Boat extends Vehicle{


  public Boat(int capacity){
    super();
    setCapacity(capacity);
    setOccupants(0);
  }

  public boolean isYacht(){
    if(getCapacity() > 50){
       return true;
     }
     return false;
  }

}
