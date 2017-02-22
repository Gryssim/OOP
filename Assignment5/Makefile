CXXFLAGS=-g -Iinclude -std=c++11
LDFLAGS=

all : bin/app

tmp/Collectable.o : src/Collectable.cpp include/Collectable.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Art.o : src/Art.cpp include/Art.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Vehicle.o : src/Vehicle.cpp include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/CustomCar.o : src/CustomCar.cpp include/CustomCar.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Car.o : src/Car.cpp include/Car.h include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Boat.o : src/Boat.cpp include/Boat.h include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/main.o : src/main.cpp include/Car.h include/Boat.h include/Vehicle.h include/Collectable.h include/Art.h include/CustomCar.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

bin/app : tmp/main.o tmp/Art.o tmp/Collectable.o tmp/Vehicle.o tmp/CustomCar.o tmp/Car.o tmp/Boat.o
	$(CXX) $(CXXFLAGS) -o $@ $^ $(LDFLAGS)
