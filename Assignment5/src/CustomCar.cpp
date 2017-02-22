#include "Vehicle.h"
#include "Art.h"
#include "CustomCar.h"

namespace vehicles{

    CustomCar::CustomCar(int capacity, double value, std::string artist )
    :
    art::Art(value, artist)
    {
      setCapacity(capacity);
    }

    int CustomCar::getNumWheels() const { return _numWheels; }
    void CustomCar::setNumWheels(int wheels){
      _numWheels = wheels;
    }
}
