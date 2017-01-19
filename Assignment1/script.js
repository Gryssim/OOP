class Vehicle {
  constructor(){
    this.capacity = null;
  }
}

class Car extends Vehicle{
  constructor(capacity){
    super();
    this.numWheels = 4;
    this.capacity = capacity;
  }
}

class Truck extends Vehicle{
  constructor(capacity, numWheels){
    super();
    this.numWheels = numWheels;
    this.capacity = capacity;
  }
}

class Boat extends Vehicle{
  constructor(capacity){
    super();
    this.capacity=capacity;
  }
}

class Console {
	constructor(id) {
		this.element = document.getElementById(id);
	}
	log(message) {
		let p = document.createElement("p");
		p.innerText = message;
		this.element.appendChild(p);
	}
}

let console = new Console("console");

let vehicles = new Array(
    new Car(4),
    new Truck(2, 6),
    new Boat(12));

vehicles.forEach(function (element){ console.log("Capacity is: " + element.capacity); } );
