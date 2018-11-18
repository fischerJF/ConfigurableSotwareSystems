package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;


import specifications.Configuration;
import tests.Example;
import tests.Pilot;
import tests.Pilot_CommandLine;
import tests.Pilot_REPAIR;
import tests.TestBasics;
import tests.TestCombinations;
import tests.TestObeservability;
import tests.TestProxying;
import tests.TestUndo;


public class BaselineAdapter {
     PowerSet powerset;
     
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

		Feature f7 = new Feature();
		f7.setType(FeatureType.OPTIONAL);
				
		Feature f8 = new Feature();
		f8.setType(FeatureType.OPTIONAL);
		
		Feature f9 = new Feature();
		f9.setType(FeatureType.OPTIONAL);

		Feature f10 = new Feature();
		f10.setType(FeatureType.OPTIONAL);
		
		SPL spl = new SPL();		
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
		spl.addOthersFeature(f7);
		spl.addOthersFeature(f8);
		spl.addOthersFeature(f9);
		spl.addOthersFeature(f10);

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
			
			starFeature();
			for (Integer integer2 : integer) {
				
				if(integer2 == 0) Configuration.TREE_STRUCTURE=true;
				if(integer2 == 1) Configuration.LOGGING=true;
				if(integer2 == 2) Configuration.CUT_WHATEVER=true;
				if(integer2 == 3) Configuration.CUT_NO_DEPARTMENT=true;
				if(integer2 == 4) Configuration.CUT_NO_MANAGER =true;
				if(integer2 == 5) Configuration.GUI =true;
				if(integer2 == 6) Configuration.PRECEDENCE =true;
				if(integer2 == 7) Configuration.TOTAL_WALKER =true;
				if(integer2 == 8) Configuration.TOTAL_REDUCER =true;
				if(integer2 == 9) Configuration.ACCESS_CONTROL =true;

				System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
			 // Configuration.productPrint();
				cont++;
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			 org.junit.runner.Result result = junit.run(
			      Pilot.class,  
		        Pilot_CommandLine.class, 
		        Example.class, 
		        Pilot_REPAIR.class, 
		        TestBasics.class,
		        TestProxying.class,
		        TestUndo.class,
		        TestCombinations.class,
		        TestObeservability.class  
					 );
			/* fim core junit */
			
			
			}else {
				//System.err.println("Inválido");
			}
		}
		System.out.println("Contador de produtosfffffffffffff:" + cont);
	}
	
	private void starFeature() {
		Configuration.TREE_STRUCTURE=false;
		Configuration.LOGGING=false;
		Configuration.CUT_WHATEVER=false;
		Configuration.CUT_NO_DEPARTMENT=false;
		Configuration.CUT_NO_MANAGER =false;
		Configuration.GUI =false;
		Configuration.PRECEDENCE =false;
		Configuration.TOTAL_WALKER =false; 
		Configuration.TOTAL_REDUCER =false; 
		Configuration.ACCESS_CONTROL =false; 

	}
	
}
