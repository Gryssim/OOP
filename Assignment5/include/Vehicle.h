#pragma once

#include "Collectable.h"

namespace vehicles{

  class Vehicle: public virtual collection::Collectable{
  public:
    Vehicle();
    virtual int getCapacity() const;
    virtual void setCapacity(int capacity);
    virtual int getRoomLeft();
    virtual int getOccupants() const;
    virtual void setOccupants(int occupants);


    virtual ~Vehicle();


  private:
    int _capacity;
    int _occupants;
    int _roomLeft;

    virtual void _calcRoomLeft();
  };
}
