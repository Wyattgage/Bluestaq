/*==============================*/
/*         The Elevator         */
/*           9/2/2024           */
/*         Wyatt G Gage         */
/*==============================*/

package elevator_v1;

//Class representing a passenger requesting the elevator from a source floor to a destination floor
class Passenger 
{
	 private int destinationFloor;	// The floor the passenger wants to go to
	 private int sourceFloor; 		// The floor the passenger's request came from
	
	 // Constructor for Passenger
	 public Passenger(int destinationFloor, int sourceFloor) 
	 {
	     this.destinationFloor = destinationFloor;
	     this.sourceFloor = sourceFloor;
	 }
	
	 // Get the destination floor for the passenger
	 public int getDestinationFloor() 
	 {
	     return destinationFloor;
	 }
	 
	 // Get the source floor for the passenger
	 public int getSourceFloor() 
	 {
	     return sourceFloor;
	 }
}