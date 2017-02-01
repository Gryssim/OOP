#include <iostream>
#include <vector>

#include "Vehicle.h"
#include "Car.h"
#include "Boat.h"

int main(int argc, char *argv[]){
  std::vector <vehicles::Vehicle*> vehicles;
  vehicles.push_back(new vehicles::Car(4));
  vehicles.push_back(new vehicles::Boat(55));

  vehicles::Car *volt = new vehicles::Car(4);
  std::cout << "Room left in the car: " << volt->getRoomLeft() << std::endl;
  volt->setOccupants(1);
  std::cout << "Room left in the car: " << volt->getRoomLeft() << std::endl;

  for(int i = 0; i < vehicles.size(); i++){
    std::cout << "Room left in the vehicle: "
              << vehicles[i]->getRoomLeft() << std::endl;
  }
}
