package adapter;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import SPLstructure.Feature;
import SPLstructure.FeatureType;
import SPLstructure.SPL;
import elevatorsystem_varexj.Actions;
import elevatorsystem_varexj.Elevator;
import elevatorsystem_varexj.Environment;
import elevatorsystem_varexj.Person;
import sampling.SamplingConfiguration;
import specifications.Configuration;
import testset.ActionsTest;
import testset.ElevatorTest;
import testset.EnvironmentTest;
import testset.FloorTest;
import testset.MainTest;
import testset.PersonTest;

public class SamplingAdapter {
	
	
	public void samplingRun() {
		Feature f1 = new Feature();
		f1.setType(FeatureType.MANDATORY);

		Feature f2 = new Feature();
		f2.setType(FeatureType.OPTIONAL);

		Feature f3 = new Feature();
		f3.setType(FeatureType.OPTIONAL);

		Feature f4 = new Feature();
		f4.setType(FeatureType.OPTIONAL);

		Feature f5 = new Feature();
		f5.setType(FeatureType.OPTIONAL);

		Feature f6 = new Feature();
		f6.setType(FeatureType.OPTIONAL);

		SPL spl = new SPL();
		
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
		
		SamplingConfiguration conf1 = new SamplingConfiguration(spl);
		SamplingConfiguration conf2 = new SamplingConfiguration(spl);
		SamplingConfiguration conf3 = new SamplingConfiguration(spl);
		SamplingConfiguration conf4 = new SamplingConfiguration(spl);

	
		// System.out.println("one_Enabled");
		conf1.one_Enabled();
		runConfiguration(conf1);

		// System.out.println("one_Disabled ");
		conf2.one_Disabled();
		runConfiguration(conf2);

		// System.out.println("most_Enabled_Disabled");
		conf3.most_Enabled_Disabled();
		runConfiguration(conf3);

		// System.out.println("pairWise");
		conf4.pairWise(5, 2);
		runConfiguration(conf4);
	}

	private  void runConfiguration(SamplingConfiguration conf) {
		Configuration elevator = new Configuration();
		for (int j = 0; j < conf.getListConfiguration().size(); j++) {

			ArrayList<Feature> temp = conf.getListConfiguration().get(j).getOthersFeatureList();
			elevator.base = true;
			elevator.weight = temp.get(0).getStatus() == 1 ? true : false;
			elevator.empty = temp.get(1).getStatus() == 1 ? true : false;
			elevator.twothirdsfull = temp.get(2).getStatus() == 1 ? true : false;
			elevator.executivefloor = temp.get(3).getStatus() == 1 ? true : false;
			elevator.overloaded = temp.get(4).getStatus() == 1 ? true : false;

			// testSplat();

		//	System.out.println(toString(elevator));

			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			org.junit.runner.Result result = junit.run(ElevatorTest.class, EnvironmentTest.class, ActionsTest.class,
					FloorTest.class, PersonTest.class, MainTest.class);
			/* fim core junit */
		}

	}

	public  void samplingTest() {
		int cleanupTimeShifts = 10;
		if (!Configuration.validProduct()) {
			// throw new RuntimeException("invalid configuration");
			System.err.println("invalid configuration");
		}
		Environment env = new Environment(5);
		Elevator e = new Elevator(env, 4, false);

		Actions a = new Actions(env, e);

		Person bob = a.bobCall();
		// System.out.println("andar:" + e.getCurrentFloorID());
		while (env.getFloor(bob.getOrigin()).hasCall())
			e.timeShift();

		e.timeShift();

		a.bobCall();
		for (int i = 0; i < cleanupTimeShifts && !e.isBlocked(); i++) {
			e.timeShift();
			System.out.println("i: " + i + " = " + e.toString());
		}
	}

	 
	
	public  String toString(Configuration elevator) {
		return "\nbase:\t " + elevator.base + "\nweight:\t " + elevator.weight + "\nempty:\t " + elevator.empty
				+ "\ntwothirdsfull:\t " + elevator.twothirdsfull + "\nexecutivefloor:\t " + elevator.executivefloor
				+ "\noverloaded:\t" + elevator.overloaded;

	}

}
