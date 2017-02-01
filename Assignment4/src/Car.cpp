#include "Car.h"

namespace vehicles{
  Car::Car(int capacity){
    _numWheels = 4;
    setCapacity(capacity);
    setOccupants(0);
  }
  int Car::getNumWheels() const { return _numWheels; }
  void Car::setNumWheels(int wheels){
    _numWheels = wheels;
  }
}
