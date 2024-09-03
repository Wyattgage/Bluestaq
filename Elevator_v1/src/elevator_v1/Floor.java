/*==============================*/
/*         The Elevator         */
/*           9/2/2024           */
/*         Wyatt G Gage         */
/*==============================*/

package elevator_v1;

//Class representing an available floor (Currently not utilized but made sense to add)
class Floor 
{
	 private int floorNumber; // The floor number
	
	 // Constructor for Floor
	 public Floor(int floorNumber) 
	 {
	     this.floorNumber = floorNumber;
	 }
	
	 // Get the floor number
	 public int getFloorNumber() 
	 {
	     return floorNumber;
	 }
}