package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ElevatorSystem.Environment;
import ElevatorSystem.Person;

public class PersonTestSplat {

	@Test
	public void testPerson() {
		Environment env = new Environment(5);
		Person person=  new Person("Paulo", 40, 1, 4, env);
		
		assertEquals(person.getName(), "Paulo");
		assertEquals(person.getWeight(), 40);
		assertEquals(person.getOrigin(), 1);
		assertEquals(person.getDestination(), 4);
		
		
	}

}
