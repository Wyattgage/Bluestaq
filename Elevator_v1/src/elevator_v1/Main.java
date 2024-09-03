/*==============================*/
/*         The Elevator         */
/*           9/2/2024           */
/*         Wyatt G Gage         */
/*==============================*/

package elevator_v1;

import java.util.Scanner;

public class Main 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		// Set variable default value
	    String userInput = "";	
	    
	    // Loop for user input
	    while(true)
	    {
	    	// Request user input
		    System.out.println("--------------------------------------------------------------------------");
		    System.out.println("Type A for Automatic | Type I for Interactive | Type E to Exit the program");
		    System.out.println("--------------------------------------------------------------------------");

	    	userInput = scanner.nextLine();			// Collect user input
	    	
	    	// Check user input
		    switch(userInput.toUpperCase()) 		// Set all text to upper-case
		    {
			    case "A":
			    	runAutomaticSimulation();		// Run Automatic Simulation
			    	break;
			    case "I":
			    	runInteractiveSimulation();		// Run Interactive Simulation
			    	break;
			    case "E":
			    	scanner.close();				// Close scanner
			    	System.out.println("\n\n===============\nClosing Program\n===============\n\n");
			    	System.exit(0);					// Exit Program
			    	break;
			    default:
			    	System.out.println("\n\n!!!ERROR!!! Invalid Input\n\n");
			    	break;
		    }
	    }
	}
	
	// Run an automatic simulation of the elevator
	private static void runAutomaticSimulation() 
	{
		// Create an instance of ElevatorController with a number of floors (10)
		ElevatorController controller = new ElevatorController(10);
		
	    // Requests submitted by passengers (Simulation)
	    controller.requestElevator(7, 1);  // A passenger request for the elevator | floor 7  -> floor 1
	    controller.requestElevator(3, 10); // A passenger request for the elevator | floor 3  -> floor 10
	    controller.requestElevator(2, 6);  // A passenger request for the elevator | floor 2  -> floor 6
	    controller.requestElevator(6, 1);  // A passenger request for the elevator | floor 6  -> floor 1
	    controller.requestElevator(10, 3); // A passenger request for the elevator | floor 10 -> floor 3
	    controller.requestElevator(3, 3);  // A passenger request for the elevator | floor 3  -> floor 3
	    controller.requestElevator(5, 1);  // A passenger request for the elevator | floor 5  -> floor 1
	    
	    // Process all current requests
	    controller.processRequests();
	    
	    System.out.println("\n===================\nSimulation Complete\n===================\n\n");
	}
	
	// Run an interactive simulation of the elevator
	private static void runInteractiveSimulation() 
	{	
		// Set variables default values
	    boolean collectUserInput = true;
	    int userInputFloorLimit = 0;
	    String userInput = "";	
	    
	    // Loop for user input
	    while(collectUserInput)
	    {	    
	    	try
	    	{
		    	// Request user input
			    System.out.println("\nEnter the number of floors for the elevator:");
		    	userInput = scanner.nextLine();							// Collect user input
			    
		    	userInputFloorLimit = Integer.parseInt(userInput);		// Parse input to an integer
		    	
		    	if(userInputFloorLimit > 0)
		    	{
			    	collectUserInput = false;							// Stop expectation for user input
		    	}
		    	else
		    	{
		    		throw new Exception("Negative number not allowed");	// Throw exception if number of floors are not positive
		    	}
	    	}
	    	catch(Exception e) 			// Catch Exception
	    	{
			    System.out.println("\n\n!!!ERROR!!! Invalid number of floors given\n\n");
	    	}
	    }
	    
	    // Reset expectation for user input
	    collectUserInput = true;
	    
		// Create an instance of ElevatorController with a number of floors
		ElevatorController controller = new ElevatorController(userInputFloorLimit);
	    
	    // Loop for user input
	    while(collectUserInput)
	    {	    	
	    	// Request user input
		    System.out.println("\n----------------------------------------------------------------------");
		    System.out.println("Type R to submit a Request to the elevator | Type E to Exit simulation");
		    System.out.println("----------------------------------------------------------------------");

	    	userInput = scanner.nextLine();			// Collect user input
	    	
	    	//Check user input
		    switch(userInput.toUpperCase()) 		// Set all text to upper-case
		    {
			    case "R":
			    	try
			    	{
				    	// Request user input
					    System.out.println("\nEnter a number for the Source Floor between 1 and " + userInputFloorLimit + ":");
				    	int userInputSourceFloor = Integer.parseInt(scanner.nextLine());			// Collect user input / Parse input to an integer
				    	
				    	// Request user input
					    System.out.println("\nEnter a number for the Destination Floor between 1 and " + userInputFloorLimit + ":");
				    	int userInputDestinationFloor = Integer.parseInt(scanner.nextLine());		// Collect user input / Parse input to an integer
				    	
				    	// Ensure inputed floor numbers are positive and don't exceed the number of floors available
				    	if(userInputSourceFloor <= userInputFloorLimit && userInputDestinationFloor <= userInputFloorLimit && userInputSourceFloor > 0 && userInputDestinationFloor > 0)
				    	{
						    controller.requestElevator(userInputSourceFloor, userInputDestinationFloor);  // A passenger request for the elevator
						    controller.processRequests();	// Process all current requests
				    	}
				    	else
				    	{
						    System.out.println("\n\n!!!ERROR!!! Invalid floor numbers given\n\n");
				    	}
			    	}
			    	catch(Exception e) 			// Catch Exception
			    	{
					    System.out.println("\n\n!!!ERROR!!! Invalid floor numbers given\n\n");
			    	}
			    	break;
			    case "E":
			    	collectUserInput = false;	// Stop expectation for user input
			    	break;
			    default:
			    	System.out.println("\n\n!!!ERROR!!! Invalid Input\n\n");
			    	break;
		    }
	    }
	    System.out.println("\n\n===================\nSimulation Complete\n===================\n\n");
	}
}