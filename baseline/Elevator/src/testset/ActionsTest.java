package testset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import elevatorsystem_varexj.Actions;
import elevatorsystem_varexj.Elevator;
import elevatorsystem_varexj.Environment;
import elevatorsystem_varexj.Person;

public class ActionsTest {

	@Before
	public void setUp(){
		
	}
	@Test
	public void testPressInLift0() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, 4, false);
		e.enterElevator(new Person("Paulo", 40, 1, 4, env));
		Actions a = new Actions(env, e);
		
		a.pressInLift0() ;
		assertTrue(e.floorButtons[0]);
	}

	@Test
	public void testPressInLift0EmptyElevator() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, 4, false);
	
		Actions a = new Actions(env, e);
		
		a.pressInLift0() ;
		assertFalse(e.floorButtons[0]);
	}
	
}
