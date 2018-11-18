package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ElevatorSystem.*;

public class FloorTest {

	@Before
	public void setUp(){
		
	}
	@Test
	public void testProcessWaitingPersons() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, false, 4, false);
		e.enterElevator(new Person("Paulo", 40, 1, 4, env));
		
		Floor f= new Floor(1);
		
		f.processWaitingPersons(e);
		
		//assertTrue(f.getWaiting().size()==0);
		//assertFalse(f.isElevatorCall());
		
	}

	@Test
	public void testAddWaitingPerson() {
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, false, 4, false);
		Person person=  new Person("Paulo", 40, 1, 4, env);
		
		
		Floor f= new Floor(1);
		
		f.addWaitingPerson(person);
		
		//assertTrue(f.isElevatorCall());
		//assertEquals(f.getWaiting().get(0),person);
	}
}
