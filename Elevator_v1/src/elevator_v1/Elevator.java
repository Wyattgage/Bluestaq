/*==============================*/
/*         The Elevator         */
/*           9/2/2024           */
/*         Wyatt G Gage         */
/*==============================*/

package elevator_v1;

import java.lang.Math;
import java.util.concurrent.TimeUnit;

//Class representing the elevator
class Elevator 
{
	 private int currentFloor;		// The floor the elevator is currently on
	 private int speed;				// The speed, in milliseconds, the elevator takes to travel from one floor to another
	 private boolean doorClosed;	// Boolean for if the elevator door is closed
	 private char moveSymbol;		// Char to represent the direction the elevator is moving (↑ ↓ -)
	 Direction direction; 			// The direction the elevator is moving
	
	 // Constructor for Elevator
	 public Elevator() 
	 {
	     currentFloor = 1;               // Elevator begins on the first floor
	     speed = 200;					 // Elevator speed is 200ms
	     doorClosed = true;				 // Elevator door begins closed
	     moveSymbol = '-';				 // Elevator begins stationary
	     direction = Direction.NONE;     // Elevator begins stationary
	 }
	
	 // Get status of the elevator door
	 public boolean getDoorClosed() 
	 {
	     return doorClosed;
	 }
	 
	 // Get the floor the elevator is currently on
	 public int getCurrentFloor() 
	 {
	     return currentFloor;
	 }
	
	 // Get the direction the elevator is moving
	 public Direction getDirection() 
	 {
	     return direction;
	 }
	 
     // Determine the direction the elevator needs to move to get to the target floor
	 private void determineElevatorDirection(int targetFloor)
	 {
         if (targetFloor > currentFloor) 
         {
             direction = Direction.UP;   // Set direction to UP if target is above
             moveSymbol = '↑';			 // Set move symbol to ↑
         } 
         else if (targetFloor < currentFloor) 
         {
             direction = Direction.DOWN; // Set direction to DOWN if target is below
             moveSymbol = '↓';			 // Set move symbol to ↓
         }
         else
         {
        	 direction = Direction.NONE; // Set direction to NONE if target is the same as currentFloor
        	 moveSymbol = '-';			 // Set move symbol to -
         }
	 }
	 
	 // Move the elevator to the target floor
	 public void moveToFloor(int targetFloor)
	 {
	     // Determine the direction the elevator is heading towards
		 determineElevatorDirection(targetFloor);
		 
	     System.out.println("Elevator moving " + direction + " from: [" + currentFloor + "] to [" + targetFloor + "]");
	     
	     int distance = Math.abs(currentFloor - targetFloor);		// Ensure distance is a positive number
	     
	     // Simulate movement of the elevator from current floor to target floor
	     try
	     {
		     for (int i = 1; i < distance ; i++) 
		     {
			     System.out.println(moveSymbol);
			     TimeUnit.MILLISECONDS.sleep(speed);		// Simulate pause for elevator movement
		     }
		     
		     System.out.println(moveSymbol + " Arrived at: [" + targetFloor + "]");
		     TimeUnit.MILLISECONDS.sleep(speed);			// Simulate pause for elevator movement
	     }
	     catch(Exception InterruptedException)				// Catch expected Exception
	     {
		     System.out.println("\n\nSleep thread interrupted\n\n");
		     System.exit(1);		// Exit Program
	     }
	     
	     currentFloor = targetFloor;     // Update the current floor to the targetFloor
	 }
	 
	 
}