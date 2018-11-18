package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import specifications.Configuration;
import tests.TestDifficultSituations;
import tests.TestMain;
import tests.TestPatternMatching;
import tests.TestTextAccess;
import tests.TestTokenizerFlags;
import tests.TestTokenizerProperties;




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
    
    
		SPL spl = new SPL();		
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		
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
				
				if(integer2 == 0) Configuration.TOKENPOSONLY=true;
				if(integer2 == 1) Configuration.COUNTLINES=true;
				if(integer2 == 2) Configuration.IMAGEPARTS=true;
				if(integer2 == 3) Configuration.BLOCKCOMMENTS=true;
				if(integer2 == 4) Configuration.LINECOMMENTS =true;
			

				System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
				cont++;
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			 org.junit.runner.Result result = junit.run(
			      TestMain.class,
			      TestPatternMatching.class,
			      TestTokenizerFlags.class,
			      TestTextAccess.class,
			      TestTokenizerProperties.class,
			      TestDifficultSituations.class
					 );
			/* fim core junit */
			
			
			}else {
				System.err.println("Inválido");
			}
		}
		System.out.println("Contador de produtos:" + cont);
	}
	
	private void starFeature() {
		Configuration.TOKENPOSONLY=false;
		Configuration.COUNTLINES=false;
		Configuration.IMAGEPARTS=false;
		Configuration.BLOCKCOMMENTS =false;
		Configuration.LINECOMMENTS =false;
	

	}
	
}
