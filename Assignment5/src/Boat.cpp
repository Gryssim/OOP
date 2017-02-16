#include "Boat.h"

namespace vehicles{
  Boat::Boat(int capacity){
    setCapacity(capacity);
    setOccupants(0);
  }

  bool Boat::isYacht(){
    if(getCapacity() > 50){
      return true;
    }
    return false;
  }
}
