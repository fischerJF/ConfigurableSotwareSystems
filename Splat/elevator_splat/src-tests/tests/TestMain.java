package tests;

import org.junit.Test;

import splat.ElevatorVariables;
import elevator.ElevatorSystem.Elevator;
import elevator.ElevatorSystem.Environment;
import elevator.ElevatorSystem.Person;
import elevator.defpackage.PL_Interface;
import elevator.defpackage.PL_Interface_impl;

public class TestMain extends ElevatorTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
//		if (strTestName.equals("testBestScenario")
//				|| strTestName.equals("testAverageScenario")
//				|| strTestName.equals("testWorstScenario")) {
//			//it works with just BASE___ feature enabled
//		} else {
//			System.err.printf("%s did not set default configuration",
//					strTestName);
//		}
	}


	@Test
	public void testAverageScenario() {
		int floorsCount = ElevatorVariables.FLOORS / 2;
		Environment env = new Environment(floorsCount);
		Elevator elevator = new Elevator(env, false);

		// Add waiting persons
		int eachPersonWeight = 10;
		int numPersons = (Elevator.maximumWeight / eachPersonWeight) - 1;
		for (int i = 0; i < numPersons; i++) {
			new Person("p" + i, eachPersonWeight, 0, floorsCount - 1, env);
		}

		// Last person makes pushes the limit
		new Person("p" + numPersons, eachPersonWeight + 1, floorsCount / 2,
				floorsCount - 1, env);

		// Wait until the elevator arrives to the last person's floor
		int lastPersonFloor = floorsCount / 2;
		while (elevator.getCurrentFloorID() != lastPersonFloor)
			elevator.timeShift();

		// Before last person gets on, elevator should be operational
                //		System.out.println("Before last person: " + elevator.isBlocked());

		elevator.timeShift();
		elevator.timeShift();
		elevator.timeShift();
		elevator.timeShift();

		// AFter last person gets on, elevator is blocked
                //		System.out.println("After last person: " + elevator.isBlocked());
	}

	static boolean printLog = false;
	public static String ignoreThisRun = "false";
	public static String error = null;

	@Test
	public void testWorstScenario() {
		PL_Interface interf = new PL_Interface_impl();
		try {
			int specification = 14;
			interf.checkOnlySpecification(specification);
			int variation = -1;

			// start program
			interf.start(specification, variation);
			if (interf.isAbortedRun() == true) {
				if (printLog)
					System.out.println("Aborted");
				ignoreThisRun = "true";
				return;
			}
			if (printLog)
				System.out.println("Scenario Succeeded");
		} catch (Throwable e) {
			if (printLog) {
				System.out.println("Scenario Failed with error:"
						+ e.getMessage());
				e.printStackTrace();
			}
			error = e.getMessage();
		}

	}
	
	
	@Test
  public void testBestScenario() {
    int floorsCount = ElevatorVariables.FLOORS;
    Environment env = new Environment(floorsCount);
    Elevator elevator = new Elevator(env, false);

    // Add waiting persons
    int totalWeight = 0;
    int personCount = 0;
    for (int i = 0; i < floorsCount - 100; i++) {
      for (int j = 0; j < 20; j++) {
        int pWeight = 40;
        new Person("p" + personCount++, pWeight, i, 0, env);
        totalWeight += pWeight;
      }
    }

    // Go through each floor and pick up waiting persons
    for (int i = 0; i < floorsCount; i++)
      env.getFloor(i).processWaitingPersons(elevator);

    // Check the weight
    assert totalWeight == elevator.weight;
  }

	

}
