package experiment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import adapter.BaselineAdapter;
import adapter.SPLat_PeterKimAdpater;
import adapter.SamplingAdapter;
import adapter.VarexJAdapter;


public class Main {
	public static void main(String[] args) throws Exception {

		searchTime(args);

	}

	private static void searchTime(String[] args) throws Exception {
		
		long startTime = 0;
		long finishTime = 0;
		long somatorio = 0;
		int totalExecution = 10;
		int index = 0;
		finishTime = 0;

		startTime = System.currentTimeMillis();

	//	while (index < totalExecution) {
			
			/* executa pelo splat */			
		//	SamplingAdapter sampling = new SamplingAdapter();
		 //  sampling.samplingRun();
			
		
		 /***** S-SPLat   spalt versão Sabrina *****/
		/*
		
		PrintStream log = new PrintStream(new File("elevador_splat.txt"));
		String dataPath = (new java.io.File("./../..")).getCanonicalPath().toString() + "";
		    
		    Sampling.mode = Mode.SPLAT;
		    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
		        dataPath+"elevador_splat.txt",
		        "--shouldsample", "false", "--samplerate", "1", "--seed", "95729",
		        "--validate", "true" };
		    List<TestResults> resultsSplat = ExperimentRunner.runExp(args,
		    		ElevatorVariables.getSINGLETON());
		*/
		    /********* fim  *******/
	

			/* executa pelo VarexJ */
		VarexJAdapter varexj= new VarexJAdapter();
		varexj.varexjRun();
			
			/*executa com Baseline*/
			//BaselineAdapter baseline= new BaselineAdapter();
			//baseline.baselineRun();
			
			/*executa pelo splat peter kim*/
//			SPLat_PeterKimAdpater splat = new SPLat_PeterKimAdpater();
//			splat.splatPKRun();
			
			index++;
	//	}
		finishTime = System.currentTimeMillis() - startTime;


		float media = finishTime / index;

		System.out.println(
				"Tempo gasto total (milisegundos): " + finishTime + " tempo médio (milisegundos): " + media + " número de vezes executadas:" + index);

	}

	

	
}
