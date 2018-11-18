package ElevatorSystem; 

import splat.ElevatorTEST;

public   class  Environment {

	//@Symbolic("false")
	Floor[] floors;



	public Environment  (int numFloors) {
		floors = new Floor[numFloors];
		for (int i = 0; i < numFloors; i++) {
			floors[i] = new Floor(i);
		}

		floors = new Floor[numFloors];
		for (int i = 0; i < numFloors; i++) {
			floors[i] = new Floor(i);
		}
	}



	public Floor  getFloor__before__empty(int id) {
		return floors[id];
	}



	public Floor  getFloor__role__empty(int id) {
		return floors[id];
	}



	public Floor getFloor(int id) {
		/*    if (ElevatorSpecOneKORAT.get_EMPTY___()) {
        return getFloor__role__empty(id);
    } else {
        return getFloor__before__empty(id);
    }  */
		return floors[id];
	}



/*
	public Floor[]  getFloors__before__empty() {
		return floors;
	}


	public Floor[]  getFloors__role__empty() {
		return floors;
	} */


	public Floor[]
	             getFloors() {
	/*	if (ElevatorSpecOneKORAT.get_EMPTY___()) {
			return getFloors__role__empty();
		} else {
			return getFloors__before__empty();
		} */
		return floors;
	}



/*
	public boolean  isTopFloor__before__empty(int id) {
		return id == floors.length-1;
	}


	public boolean  isTopFloor__role__empty(int id) {
		return id == floors.length-1;
	}
*/

	public boolean isTopFloor(int id) {
		/*if (ElevatorSpecOneKORAT.get_EMPTY___()) {
			return isTopFloor__role__empty(id);
		} else {
			return isTopFloor__before__empty(id);
		} */
		
		return id == floors.length-1;
	}
}
