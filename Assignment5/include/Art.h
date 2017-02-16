#pragma once
#include <string>

#include "Collectable.h"

namespace art{
  class Art : Collectable{
  public:
    Art(double value, string artist);

    int getValue() const;
    void setValue(double value);

    string getArtist() const;

  private:
    double _value;
    string _artist;
  }
}
