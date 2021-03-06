package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ElevatorSystem.Actions;
import ElevatorSystem.Elevator;
import ElevatorSystem.Environment;
import ElevatorSystem.Person;

public class ActionsTestSplat {

	
	@Test
	public void testPressInLift() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, false, 4, false);
		e.enterElevator(new Person("Paulo", 40, 1, 4, env));
		Actions a = new Actions(env, e);
		
		a.pressInLift0() ;
		assertTrue(e.floorButtons[0]);
	}

	@Test
	public void testPressInLiftEmptyElevator() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, false, 4, false);
	
		Actions a = new Actions(env, e);
		
		a.pressInLift0() ;
		assertFalse(e.floorButtons[0]);
	}
	
}
