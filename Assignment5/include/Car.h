#pragma once
#include "Vehicle.h"

namespace vehicles{
  class Car : public Vehicle{
  public:
    Car(int capacity);

    int getNumWheels() const;
    void setNumWheels(int wheels);


  private:
    int _numWheels;
  };
}
