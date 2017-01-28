// Assignment 2

class Vehicle {
  constructor(){
    this.capacity = null;
  }
}


class Car extends Vehicle{
  constructor(capacity){
    super();
    this._numWheels = 4;
    this._capacity = capacity;
    this._occupants = 0;
    this._roomLeft = null;
  }
  get numWheels() { return this._numWheels; }

  get capacity() { return this._capacity; }

  set capacity(value){
    this._capacity = value;
  }

  get roomLeft() {
    this._calcRoomLeft();
    return this._roomLeft;
  }

  get occupansts() { return this._occupants; }

  set occupants(value){
    this._occupants = value;
    this._calcRoomLeft();
  }

  _calcRoomLeft(){
    this._roomLeft = this._capacity - this._occupants;
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

let volt = new Car(4);

volt.occupants = 1;

console.log("Room left in the vehicle: " + volt.roomLeft);
