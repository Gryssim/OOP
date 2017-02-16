#include "Art.h"

namespace art{
  Art::Art(double value, string artist){
    _value = value;
    _artist = artist;
  }

  int Art::getValue() const { return value; }
  void Art::setValue(double value){
    _value = value;
  }

  string getArtist() const { return _artist; }

}
