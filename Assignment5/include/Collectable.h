#pragma once

#include <vector>
#include <string>

namespace collection{
  class Collectable{
  public:
    Collectable();
    void AddBuyer(std::string buyer);
    std::vector<std::string> GetBuyers();


  private:
    std::vector<std::string> _buyers;
  };
}
