Overview of Program:
--------------------
This program simulates the functionality of an elevator.
Floor numbers are represented by digits wrapped in square brackets. (Example: [1])
As the elevator moves from one floor to the next floor, the system simulates the movement with a symbol (↑ ↓ -) and a pause of 200ms.
User inputs are verified to avoid unneeded program failures. If user inputs are found to be incorrect a message will be displayed and a new input will be requested.

This elevator program can run 2 different simulations. Both of the simulations use the same logic but allow/require the user to interact with the simulation at different levels explained below:
[The Automatic Simulation]: Automatically runs through a hard-coded group of passenger requests for the elevator with a hard-coded number of floors available.
[The Interactive Simulation]: Prompts the user for the number of floors they would like for the elevator. Followed by a decision to either submit a passenger request for the elevator or exit. The user can keep submitting passenger requests indefinitely.



Assumptions:
------------
The elevator will prioritize passenger requests based on the order in which they are received.
All passenger requests for the elevator are submitted with the following information: (int x, int y)
	x = The floor the passenger was at when they sent the request (Source Floor)
	y = The floor the passenger requested to go to (Destination floor)



Non-Implemented Feature Ideas:
------------------------------
Added a Floor object & relevant logic that is not really utilized but made sense to add if implementing the below feature:
Implement ability to prioritize the most efficient route between floors for multiple requests.
