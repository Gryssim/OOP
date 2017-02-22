#include "Art.h"

namespace art{
  Art::Art(double value, std::string artist){
    _value = value;
    _artist = artist;
  }

  int Art::getValue() const { return _value; }
  void Art::setValue(double value){
    _value = value;
  }

  std::string Art::getArtist() const { return _artist; }

}
