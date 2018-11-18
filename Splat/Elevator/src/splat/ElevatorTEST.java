package splat;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import korat.finitization.IFinitization;
import runspl.RunSPL;
import ElevatorSystem.Elevator;
import ElevatorSystem.Environment;
import ElevatorSystem.PL_Interface;
import ElevatorSystem.PL_Interface_impl;
import ElevatorSystem.Person;

public class ElevatorTEST {
	public static String scenarioFinished = "false";
	public static String actions = "";
	public static String selectedFeatures = "";
	public static String ignoreThisRun = "false";
	public static String error = null;
	static boolean printLog = false;
	
	static String FLOORS_COUNT;
	static String FEATURE_MODEL_PATH;
	static String EXECUTION_MODE;
	static String TEST_CASE;
	
	public static ElevatorTEST SINGLETON = new ElevatorTEST();
	
	public boolean BASE___;
	public boolean WEIGHT___;
	public boolean EMPTY___;
	public boolean TWOTHIRDSFULL___;
	public boolean EXECUTIVEFLOOR___;
	public boolean OVERLOADED___;
	
	public static int FLOORS;
	
	public boolean repOK() {
		SINGLETON = this;
		PrintStream original = System.out;
		
		try {
			ElevatorTEST.main(new String[]{FLOORS_COUNT, FEATURE_MODEL_PATH, EXECUTION_MODE, TEST_CASE});
		} catch (Exception e) {
			// e.printStackTrace();
			if (e instanceof RuntimeException) throw (RuntimeException)e;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			System.setOut(original);
		}
		return false; //true for conventional execution;
	}
	
	
	/**
	 * Worst case
	 */
	public static void test2()
	{
		PL_Interface interf = new PL_Interface_impl();
		try {
			int specification = 14;
			interf.checkOnlySpecification(specification);
			int variation = -1;
	
			// start program
			interf.start(specification, variation);
			if (interf.isAbortedRun()==true) {
				if (printLog) System.out.println("Aborted");
				ignoreThisRun = "true";
				return;
			}
			if (printLog)
				System.out.println("Scenario Succeeded");
		} catch (Throwable e) {
			if (printLog) {
				System.out.println("Scenario Failed with error:" + e.getMessage());
				e.printStackTrace();
			}
			error = e.getMessage();
		}
	
	}
	/**
	 * Average
	 */
	public static void test1()
	{
		int floorsCount = ElevatorTEST.FLOORS/2;
		Environment env = new Environment(floorsCount);
		Elevator elevator = new Elevator(env, false);
	
		// Add waiting persons
		int eachPersonWeight = 10;
		int numPersons = (Elevator.maximumWeight / eachPersonWeight) - 1;		
		for(int i = 0; i < numPersons; i++)
		{ 
			new Person("p"+i, eachPersonWeight, 0, floorsCount-1, env);
		}
	
		// Last person makes pushes the limit
		new Person("p" + numPersons, eachPersonWeight+1, floorsCount/2, floorsCount-1, env);
		
		// Wait until the elevator arrives to the last person's floor
		int lastPersonFloor = floorsCount/2;
		while(elevator.getCurrentFloorID() != lastPersonFloor)
			elevator.timeShift();
		
		// Before last person gets on, elevator should be operational
		System.out.println("Before last person: " + elevator.isBlocked());
		
		elevator.timeShift();
		elevator.timeShift();
		elevator.timeShift();
		elevator.timeShift();
		
		// AFter last person gets on, elevator is blocked
		System.out.println("After last person: " + elevator.isBlocked());							
	}
	/**
	 * Best
	 */
	public static void test0()
	{
		int floorsCount = ElevatorTEST.FLOORS;
		Environment env = new Environment(floorsCount);
		Elevator elevator = new Elevator(env, false);
	
		// Add waiting persons
		int totalWeight = 0;
		int personCount = 0;
		for(int i = 0; i < floorsCount-100; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				int pWeight = 40; 
				new Person("p"+personCount++, pWeight, i, 0, env);
				totalWeight += pWeight; 
			}
		}
	
		// Go through each floor and pick up waiting persons
		for(int i = 0; i < floorsCount; i++)
			env.getFloor(i).processWaitingPersons(elevator);
	
		// Check the weight 
		assert totalWeight == elevator.weight;
	}
	public static void originalTests()
	{
		PL_Interface interf = new PL_Interface_impl();
		try {
			int specification = 10;
			interf.checkOnlySpecification(specification);
			int variation = -1;
	
			// start program
			interf.start(specification, variation);
			if (interf.isAbortedRun()==true) {
				if (printLog) System.out.println("Aborted");
				ignoreThisRun = "true";
				return;
			}
			if (printLog)
				System.out.println("Scenario Succeeded");
		} catch (Throwable e) {
			if (printLog) {
				System.out.println("Scenario Failed with error:" + e.getMessage());
				e.printStackTrace();
			}
			error = e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		RunSPL.startConfiguration(ElevatorTEST.class, args);
		
		FLOORS = Integer.parseInt(args[0]);
		int testCase = RunSPL.getTestCase(args);
		
		try {
			ElevatorTEST.class.getMethod("test" + testCase,new Class[]{}).invoke(null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static IFinitization finElevatorTEST(String floorsCount, String featureModelPath, String executionMode, String testCase) {
		//<passing in command-line arguments
		FLOORS_COUNT = floorsCount;
		FEATURE_MODEL_PATH = featureModelPath; 
		EXECUTION_MODE = executionMode;
		TEST_CASE = testCase;
		//>
		
		return RunSPL.createFinitization(ElevatorTEST.class);
	} 


	public boolean get_BASE___() {
		return BASE___;
	}

	public boolean get_WEIGHT___() {
		return WEIGHT___;    	
	}

	public boolean get_EMPTY___() {
		return EMPTY___;
	}

	public boolean get_TWOTHIRDSFULL___() {
		return TWOTHIRDSFULL___;    	    	
	}

	public boolean get_EXECUTIVEFLOOR___() {
		return EXECUTIVEFLOOR___;    
	}

	public boolean get_OVERLOADED___() {
		return OVERLOADED___;    
	}
}
