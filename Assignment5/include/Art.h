#pragma once
#include <string>

#include "Collectable.h"

namespace art{
  class Art: public virtual collection::Collectable{
  public:
    Art(double value, std::string artist);

    int getValue() const;
    void setValue(double value);

    std::string getArtist() const;

  private:
    double _value;
    std::string _artist;
  };
}
