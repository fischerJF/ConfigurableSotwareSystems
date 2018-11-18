package experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;


import varexj_.VarexJAdapter;

public class Main {
	public static void main(String[] args) throws Exception {

		searchTime(args);

	}

	private static void searchTime(String[] args) throws Exception {
		
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 1;
		int index = 0;
		finishTime = 0;

		startTime = System.currentTimeMillis();

		while (index < totalExecution) {
		
		
			    /***** VarexJ   *****/
			    VarexJAdapter varexj= new VarexJAdapter();
			    varexj.varexjRun();
			   
			    /****** Fim ******/
			    
			index++;
		}
		finishTime = System.currentTimeMillis() - startTime;


		float media = finishTime / index;

		System.out.println(
				"Tempo gasto total (milisegundos): " + finishTime + " tempo médio (milisegundos): " + media + " número de vezes executadas:" + index);

	}

	

	
}
