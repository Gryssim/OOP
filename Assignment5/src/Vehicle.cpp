#include "Vehicle.h"

namespace vehicles{
  Vehicle::Vehicle(){}

  int Vehicle::getCapacity() const{
    return _capacity;
  }
  void Vehicle::setCapacity(int capacity){
    _capacity = capacity;
  }
  void Vehicle::_calcRoomLeft(){
    _roomLeft = _capacity - _occupants;
  }
  int Vehicle::getRoomLeft(){
    _calcRoomLeft();
    return _roomLeft;
  }
  int Vehicle::getOccupants() const{
    return _occupants;
  }
  void Vehicle::setOccupants(int occupants){
    _occupants = occupants;
    _calcRoomLeft();
  }
  Vehicle::~Vehicle(){}
}
