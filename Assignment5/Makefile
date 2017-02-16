CXXFLAGS=-g -Iinclude -std=c++11
LDFLAGS=

all : bin/app

tmp/Vehicle.o : src/Vehicle.cpp include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Car.o : src/Car.cpp include/Car.h include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/Boat.o : src/Boat.cpp include/Boat.h include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

tmp/main.o : src/main.cpp include/Car.h include/Boat.h include/Vehicle.h
	$(CXX) $(CXXFLAGS) -c -o $@ $<

bin/app : tmp/main.o tmp/Vehicle.o tmp/Car.o tmp/Boat.o
	$(CXX) $(CXXFLAGS) -o $@ $^ $(LDFLAGS)




