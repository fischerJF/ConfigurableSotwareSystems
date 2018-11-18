package testset;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import elevatorsystem_varexj.Elevator;
import elevatorsystem_varexj.Environment;
import elevatorsystem_varexj.Person;


import specifications.Configuration;

public class ElevatorTest {

	private Elevator e;
	
	private Environment env;
	
	private Person p1;
	private Person p2;
	private Person p3;
	private Person p4; 

	@Before
	public void setUp(){
		env = new Environment(5);
		e=new Elevator(env, 4, false);
		p1 = new  Person("Maria", 60, 1, 4, env);
		p2= new Person("Paulo", 40, 1, 4, env);
		p3 = new Person("Jo�o", 80, 2, 4, env);
		p4 = new Person("Pedro", 90, 1, 4, env);
	}
	
	@Test
	public void testisBlocked() {
		Environment env = new Environment(5);
		e = new Elevator(env, 4, false);

		if (!Configuration.overloaded) {
			assertFalse(e.isBlocked());
		}

	}

	@Test
	public void testEnterElevator() {
		Environment env = new Environment(5);
		e = new Elevator(env, 4, false);
		e.enterElevator(new Person("Paulo", 40, 1, 4, env));
		assertTrue(e.floorButtons[4]);

	}

	@Test
	public void testEnterElevatorWeight() {
		
		if (Configuration.weight) {
			e.enterElevator(p1);
			e.enterElevator(p2);
			e.enterElevator(p3);
			e.enterElevator(p4);
			assertEquals(270, e.weight);			
		} 
		assertTrue(true);
		
	}
	
	@Test
	public void testLeaveElevator(){
	    e.enterElevator(p1);
	    e.enterElevator(p2);
	    e.enterElevator(p3);
		
	    assertTrue(e.leaveElevator(p1));
		assertTrue(e.leaveElevator(p2));
		assertTrue(e.leaveElevator(p3));
		assertFalse(e.leaveElevator(p4));
	}
	
	@Test
	public void testLeaveElevatorForWeight(){
			
		e.enterElevator(p1);
		e.enterElevator(p2);
		e.enterElevator(p3);
		e.enterElevator(p4);
		
		e.leaveElevator(p1);
		e.leaveElevator(p2);
		e.leaveElevator(p3);
		e.leaveElevator(p4);
		
		if(Configuration.weight){
			assertEquals(0, e.weight);
		}
			assertTrue(true);
		
		
	}
	
	@Test
	public void testLeaveElevatorForEmpty(){
		e.enterElevator(p1);
		e.enterElevator(p2);
		e.enterElevator(p3);
		e.enterElevator(p4);
		
		e.leaveElevator(p1);
		e.leaveElevator(p2);
		e.leaveElevator(p3);
		e.leaveElevator(p4);
		if(Configuration.empty){
		 for (boolean b : e.floorButtons) {
			if(b){
				assertTrue(false);
			}
		}
			assertTrue(true);
		}
		assertTrue(true);
	}
	
	/*@Test
	public void testTimeShiftOverLoaded(){
	
		when(e.stopRequestedAtCurrentFloor()).thenReturn(true);
		if(Configuration.overloaded){
			assertTrue(e.blocked);
		}
	}*/
}
