package main;
import elevatorsystem_varexj.Actions;
import elevatorsystem_varexj.Elevator;
import elevatorsystem_varexj.Environment;
import elevatorsystem_varexj.Person;
import specifications.Configuration;

public class Main {

	private static int cleanupTimeShifts = 10;

	public static void main(String[] args) {
		
		
		if (!Configuration.validProduct()) {
			throw new RuntimeException("invalid configuration");
		}
		
		
		
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, 4, false);
		
		Actions a = new Actions(env, e);

		Person bob = a.bobCall();
		System.out.println("andar:"+e.getCurrentFloorID());
		
		while (env.getFloor(bob.getOrigin()).hasCall())
			e.timeShift();
		
		
		e.timeShift();
		
		a.bobCall();
		for (int i = 0; i < cleanupTimeShifts && !e.isBlocked(); i++){
			e.timeShift();
			System.out.println("i: "+i+" = "+ e.toString());
		}
				
	}
	

}
