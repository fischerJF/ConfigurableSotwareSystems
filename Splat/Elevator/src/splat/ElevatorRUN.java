package splat;

import runspl.RunSPL;


public class ElevatorRUN {
	public static void main(String args[])
	{
	/*	RunSPL.run(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				"Elevator.m", "splat.ElevatorTEST", 
				new String[]{args[2]}, RunSPL.NO_SAVED_FEATUREMODEL); */
		
		/*RunSPL.runAll("Elevator.m", "splat.ElevatorTEST",
				new String[]{}); 
		*/
		
		
		/*RunSPL.runAll("Elevator.m", "testsetSplat.ActionTest",
				new String[]{}); 
		RunSPL.runAll("Elevator.m", "testsetSplat.ElevatorTest",
				new String[]{}); 
		*/ 
		
		RunSPL.runAll("Elevator.m", "testsetSplat.TestSuit",
				new String[]{}); 
	}
}
