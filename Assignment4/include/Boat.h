#pragma once
#include "Vehicle.h"

namespace vehicles{
  class Boat : public Vehicle{
  public:
    Boat(int capacity);
    bool isYacht();

  private:
  };
}
