#pragma once

#include <vector>
#include <string>

namespace collection{
  class Collectable{
  public:
    Collectable(){
      _buyers = { };
    }


  private:
    std::vector<string> _buyers;
  }
}
