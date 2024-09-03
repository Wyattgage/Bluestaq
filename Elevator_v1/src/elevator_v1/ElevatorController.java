/*==============================*/
/*         The Elevator         */
/*           9/2/2024           */
/*         Wyatt G Gage         */
/*==============================*/

package elevator_v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Class to control the elevator
class ElevatorController 
{
	 private Elevator elevator;             		// Elevator
	 private List<Floor> floors;            		// List of floors available
	 private Queue<Passenger> passengerQueue; 		// Queue of passenger requests
	
	 // Constructor for ElevatorController
	 public ElevatorController(int numFloors) 
	 {
	     elevator = new Elevator();           		// Initialize a new elevator
	     floors = new ArrayList<>();                // Initialize the list of floors
	     passengerQueue = new LinkedList<>();       // Initialize the passenger request queue
	
	     // Add requested number of floors to the list of floors available
	     for (int i = 1; i <= numFloors; i++) 
	     {
	         floors.add(new Floor(i));
	     }
	     
	     System.out.println("\n-------------------------------");
	     System.out.println("Elevator created with " + numFloors + " floors");
	     System.out.println("-------------------------------");
	 }
	
	 // Request an elevator from a source floor to a destination floor
	 public void requestElevator(int sourceFloor, int destinationFloor) 
	 {
	     Passenger passenger = new Passenger(destinationFloor, sourceFloor);	// Create a new passenger with a destinationFloor and a sourceFloor
	     passengerQueue.offer(passenger);                      	   				// Add the passenger to the passengerQueue
	 }
	
	 // Process current passenger requests for the elevator
	 public void processRequests() 
	 {
         int currentFloor = elevator.getCurrentFloor();				// Get the current floor of the Elevator
	     System.out.println("\n-----------------------");
	     System.out.println("Elevator location: [" + currentFloor + "]");
	     System.out.println("-----------------------");
		 
	     while (!passengerQueue.isEmpty()) 								// While the passengerQueue is not empty
	     {
	         Passenger passenger = passengerQueue.poll(); 				// Pulls the next Passenger off the queue
	         
	         int sourceFloor = passenger.getSourceFloor(); 				// Get the source floor of the Passenger
	         int destinationFloor = passenger.getDestinationFloor();	// Get the destination floor of the Passenger
	         
		     System.out.println("\nProcessing request: [" + sourceFloor + "] to [" + destinationFloor + "]\n-------------------------------------");
	         
	         // Move the elevator to the source floor
	         elevator.moveToFloor(sourceFloor);
	         
	         // Move the elevator to the destination floor
	         elevator.moveToFloor(destinationFloor);
	         
		     System.out.println();
	     }
	 }
}
