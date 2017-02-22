#include <iostream>
#include <vector>

#include "Collectable.h"
#include "Art.h"
#include "Vehicle.h"
#include "Car.h"
#include "Boat.h"
#include "CustomCar.h"

int main(int argc, char *argv[]){
  std::vector <vehicles::Vehicle*> vehicles;
  vehicles.push_back(new vehicles::Car(4));
  vehicles.push_back(new vehicles::Boat(55));

  vehicles::Car *volt = new vehicles::Car(4);
  std::cout << "Room left in the car: " << volt->getRoomLeft() << std::endl;
  volt->setOccupants(1);
  std::cout << "Room left   in the car: " << volt->getRoomLeft() << std::endl;

  for(int i = 0; i < vehicles.size(); i++){
    std::cout << "Room left in the vehicle: "
              << vehicles[i]->getRoomLeft() << std::endl;
  }

  art::Art *painting = new art::Art(400.25, "John Doe");
  vehicles::CustomCar *hotRod = new vehicles::CustomCar(2, 70000.00, "Jane Smith");

  painting->AddBuyer("Jason Olson");
  painting->AddBuyer("Brandon Breiner");

  std::vector<std::string> buyerList  = painting->GetBuyers();
  for(int i = 0; i < buyerList.size(); i++){
    std::cout <<"Painting Buyer " << i + 1 << ": " << buyerList.at(i) << std::endl;
  }

  hotRod->AddBuyer("Robert Scherlitz");
  hotRod->AddBuyer("Curtis Heuschal");


  buyerList  = hotRod->GetBuyers();
  for(int i = 0; i < buyerList.size(); i++){
    std::cout <<"Hot Rod Buyer " << i + 1 << ": " << buyerList.at(i) << std::endl;
  }

}
