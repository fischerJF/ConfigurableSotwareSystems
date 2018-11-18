package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import specifications.Configuration;
import testset.ActionsTest;
import testset.ElevatorTest;
import testset.EnvironmentTest;
import testset.FloorTest;
import testset.MainTest;
import testset.PersonTest;

public class BaselineAdapter {
     PowerSet powerset;
	 Configuration elevator;
	 
	
	public BaselineAdapter() {
		 powerset= new PowerSet();
		
	}
	
	
	
	public void baselineRun() {
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

		makeProduct(spl);
		
	}
	
	private void makeProduct (SPL spl) {
		 List<Integer> list = new ArrayList<Integer>();
		for (int cont =0; cont<spl.getOthersFeatureList().size(); cont++) {
			list.add(cont);
		}
		
		int cont =0;
		//System.out.println(powerset.getSubsetUsingBitMap(list));
		for (ArrayList<Integer> integer : powerset.getSubsetUsingBitMap(list)) {
			
			elevator = new Configuration();
			starFeature();
			for (Integer integer2 : integer) {
				
				if(integer2 == 0) elevator.weight=true;
				if(integer2 == 1) elevator.empty=true;
				if(integer2 == 2) elevator.twothirdsfull=true;
				if(integer2 == 3) elevator.executivefloor=true;
				if(integer2 == 4) elevator.overloaded =true;
				

				System.out.print(integer2+" ");
				
			}
			if(Configuration.validProduct() ) {
				cont++;
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			 org.junit.runner.Result result = junit.run(
					 ElevatorTest.class, 
					 EnvironmentTest.class, 
					 ActionsTest.class,
					 FloorTest.class, 
					 PersonTest.class, 
					 MainTest.class);
			/* fim core junit */
			
			System.out.println("\t weight:" + elevator.weight+ 
					           "\t tempty:  " + elevator.empty + 
					           "\t twothirdsfull: "+elevator.twothirdsfull+ 
					           "\t executivefloor:  "+ elevator.executivefloor+
					           "\t overloaded: "+elevator.overloaded  ) ;
			System.out.println();
			}else {
				System.err.println("Inválido");
			}
		}
		System.out.println("Contador de produtos:" + cont);
	}
	
	private void starFeature() {
		elevator.weight = false;
		elevator.empty = false;
		elevator.twothirdsfull = false;
		elevator.executivefloor = false;
		elevator.overloaded = false;

	}
	
}
