#include "Collectable.h"

namespace collection{
    Collectable::Collectable(){
      _buyers = { };
    }
    void Collectable::AddBuyer(std::string buyer){
      _buyers.push_back(buyer);
    }
    std::vector<std::string> Collectable::GetBuyers(){
      return _buyers;
    }
}
