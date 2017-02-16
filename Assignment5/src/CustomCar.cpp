#include "Vehicle.h"
#include "Art.h"

namespace vehicles{

  public:
    CustomCar::CustomCar(int capacity, double value, string artist )
    :
    collection::Collectable()
    art::Art(value, artist)
    _capacity = capacity
    {
    }

    int CustomCar::getNumWheels() const { return _numWheels; }
    void CustomCar::setNumWheels(int wheels){
      _numWheels = wheels;
    }
}
