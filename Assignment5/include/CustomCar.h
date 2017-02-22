#pragma once

#include <string>

#include "Vehicle.h"
#include "Art.h"

namespace vehicles{
  class CustomCar : public Vehicle, public art::Art{
  public:
    CustomCar(int capacity, double value, std::string artist);

    int getNumWheels() const;
    void setNumWheels(int wheels);


  private:
    int _numWheels;
  };
}
