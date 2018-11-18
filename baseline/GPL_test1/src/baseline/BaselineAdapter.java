package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import guidsl.SATtest;
import guidsl.Tool;
import specifications.Configuration;
import tests.ConnectedTests_Caio;
import tests.CycleRelated_Caio;
import tests.GraphReturnTests_Caio;
import tests.MultiFeatureTest_Caio;
import tests.NumberTests_Caio;
import tests.TestSuite_NEW;


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
		
		Feature f11 = new Feature();
		f11.setType(FeatureType.OPTIONAL);
		
		Feature f12 = new Feature();
		f12.setType(FeatureType.OPTIONAL);
		
		Feature f13 = new Feature();
		f3.setType(FeatureType.OPTIONAL);
		
		
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
		spl.addOthersFeature(f11);
		spl.addOthersFeature(f12);
		spl.addOthersFeature(f13);

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
				
				if(integer2 == 0) Configuration.base=true;
				if(integer2 == 1) Configuration.DIRECTED=true;
				if(integer2 == 2) Configuration.UNDIRECTED=true;
				if(integer2 == 3) Configuration.WEIGHTED=true;
				if(integer2 == 4) Configuration.SEARCH =true;
				if(integer2 == 5) Configuration.BFS =true;
				if(integer2 == 6) Configuration.NUMBER =true;
				if(integer2 == 7) Configuration.CONNECTED =true;
				if(integer2 == 8) Configuration.STRONGLYCONNECTED =true;
				if(integer2 == 9) Configuration.CYCLE =true;
				if(integer2 == 10) Configuration.MSTPRIM =true;
				if(integer2 == 11) Configuration.MSTKRUSKAL =true;
				if(integer2 == 12) Configuration.SHORTEST =true;

				System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
				cont++;
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			 org.junit.runner.Result result = junit.run(
					    ConnectedTests_Caio.class,
				  	    CycleRelated_Caio.class,
					    GraphReturnTests_Caio.class,
					    MultiFeatureTest_Caio.class,
						NumberTests_Caio.class,
						TestSuite_NEW.class
					 );
			/* fim core junit */
			
			
			}else {
				System.err.println("Inválido");
			}
		}
		System.out.println("Contador de produtos:" + cont);
	}
	
	private void starFeature() {
		Configuration.DIRECTED=false;
		Configuration.UNDIRECTED=false;
		Configuration.WEIGHTED=false;
		Configuration.SEARCH=false;
		Configuration.BFS =false;
		Configuration.NUMBER =false;
		Configuration.CONNECTED =false;
		Configuration.STRONGLYCONNECTED =false; 
		Configuration.CYCLE =false; 
		Configuration.MSTPRIM =false; 
		Configuration.MSTKRUSKAL =false; 
		Configuration.SHORTEST =false; 

	}
	
}
