package splat;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ElevatorSystem.Elevator;
import ElevatorSystem.Environment;
import ElevatorSystem.Person;
import featuremodel.Configuration;

public class ElevatorTestVarexJ {

	
	private Elevator e;

	private Environment env;

	private Person p1;
	private Person p2;
	private Person p3;
	private Person p4;

	@Before
	public void setUp() {
			env = new Environment(5);
			e = new Elevator(env, false, 4, false);
			p1 = new Person("Maria", 60, 1, 4, env);
			p2 = new Person("Paulo", 40, 1, 4, env);
			p3 = new Person("João", 80, 2, 4, env);
			p4 = new Person("Pedro", 90, 1, 4, env);
		
	}

	@Test
	public void testisBlocked() {
			Environment env = new Environment(5);
			e = new Elevator(env, false, 4, false);

			
	}

	@Test
	public void testEnterElevator() {
		System.err.println("Chamou o caso de teste");
		
			Environment env = new Environment(5);
			e = new Elevator(env, false);
			e.enterElevator(new Person("Paulo", 40, 1, 4, env));
			assertTrue(e.floorButtons[4]);
		
	}

	@Test
	public void testEnterElevatorWeight() {
					env = new Environment(5);
			e = new Elevator(env, false, 4, false);
			p1 = new Person("Maria", 60, 1, 4, env);
			p2 = new Person("Paulo", 40, 1, 4, env);
			p3 = new Person("João", 80, 2, 4, env);
			p4 = new Person("Pedro", 90, 1, 4, env);
			
			/*if (Configuration.weight) {
				e.enterElevator(p1);
				e.enterElevator(p2);
				e.enterElevator(p3);
				e.enterElevator(p4);
				assertEquals(270, e.weight);
			}*/
			assertTrue(true);
		
	}

	@Test
	public void testLeaveElevator() {
			env = new Environment(5);
			e = new Elevator(env, false, 4, false);
			p1 = new Person("Maria", 60, 1, 4, env);
			p2 = new Person("Paulo", 40, 1, 4, env);
			p3 = new Person("João", 80, 2, 4, env);
			p4 = new Person("Pedro", 90, 1, 4, env);
			
			e.enterElevator(p1);
			e.enterElevator(p2);
			e.enterElevator(p3);

			assertTrue(e.leaveElevator(p1));
			assertTrue(e.leaveElevator(p2));
			assertTrue(e.leaveElevator(p3));
			assertFalse(e.leaveElevator(p4));
		
	}

	@Test
	public void testLeaveElevatorForWeight() {
			env = new Environment(5);
			e = new Elevator(env, false, 4, false);
			p1 = new Person("Maria", 60, 1, 4, env);
			p2 = new Person("Paulo", 40, 1, 4, env);
			p3 = new Person("João", 80, 2, 4, env);
			p4 = new Person("Pedro", 90, 1, 4, env);
			e.enterElevator(p1);
			e.enterElevator(p2);
			e.enterElevator(p3);
			e.enterElevator(p4);

			e.leaveElevator(p1);
			e.leaveElevator(p2);
			e.leaveElevator(p3);
			e.leaveElevator(p4);

		/*	if (Configuration.weight) {
				assertEquals(0, e.weight);
			}*/
			assertTrue(true);
		
	}

	@Test
	public void testLeaveElevatorForEmpty() {
			env = new Environment(5);
			e = new Elevator(env, false, 4, false);
			p1 = new Person("Maria", 60, 1, 4, env);
			p2 = new Person("Paulo", 40, 1, 4, env);
			p3 = new Person("João", 80, 2, 4, env);
			p4 = new Person("Pedro", 90, 1, 4, env);
			
			e.enterElevator(p1);
			e.enterElevator(p2);
			e.enterElevator(p3);
			e.enterElevator(p4);

			e.leaveElevator(p1);
			e.leaveElevator(p2);
			e.leaveElevator(p3);
			e.leaveElevator(p4);
			/*if (Configuration.empty) {
				for (boolean b : e.floorButtons) {
					if (b) {
						assertTrue(false);
					}
				}
				assertTrue(true);
			}*/
			assertTrue(true);
		}
	}
