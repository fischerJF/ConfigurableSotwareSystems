package splat;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import experiment.ExperimentRunner;
import experiment.TestResults;
import sampling.Sampling;
import sampling.Sampling.Mode;


public class Main {

  public static void main(String[] args) throws Exception {
    
    PrintStream log = new PrintStream(new File("elevador_splat.txt"));
    String dataPath = (new java.io.File("./../..")).getCanonicalPath().toString() + "";

    long startTime = 0;
    long finishTime = 0;
    int totalExecution = 50;
    int index = 0;
    finishTime = 0;

    startTime = System.currentTimeMillis();

    while (index < totalExecution) {
    
        Sampling.mode = Mode.SPLAT;
        args = new String[] { "--testclass", "tests.TestAll", "--logfile",
            dataPath+"elevador_splat.txt",
            "--shouldsample", "false", "--samplerate", "1", "--seed", "95729",
            "--validate", "true" };
        List<TestResults> resultsSplat = ExperimentRunner.runExp(args,
            ElevatorVariables.getSINGLETON());
        index++;
    }
   finishTime = System.currentTimeMillis() - startTime;
   float media = finishTime / index;

   System.out.println("Tempo gasto total (milisegundos): " + finishTime
       + " tempo médio (milisegundos): " + media
       + " número de vezes executadas:" + index);
        
        
        
//    String homeDir = (new File(".")).getCanonicalPath();
//    String path = homeDir + "/bin/elevator";
//    System.out.println("Instrumenting .class");// make clean before
//   // Instrumenter.instrument(path);
//    
//    PrintStream log = new PrintStream(new File("results.txt"));
//    
//    /**Running experiment with Tries**/
//    int bound = 20; //all valid confs.
//    
//    log.printf("SAT & UNSAT & TIME\n");
//    log.printf("----------------------------------------------------\n");
//    
//  //acumulating results
//    long tc2 = 0; long tc3 = 0;
//    long cst1 = 0; long cst2 = 0;
//    int numExecutions = 2;
//    for(int i = 0; i < numExecutions; i++){
//     
//      /**SPLat/EvoSPLat**/
//      Scenario2 exp = new Scenario2();
//      long[][] sc23 = exp.run(ElevatorVariables.getSINGLETON(), bound);
//      long[] sc2 = sc23[0];
//      log.printf(sc2[0] + " & " + sc2[1] + " & " + sc2[2] + " & " + sc2[3] + "\n");
//      long[] sc3 = sc23[1];
//      log.printf(sc3[0] + " & " + sc3[1] + " & " + sc3[2] + " & " + sc3[3] + "\n");
//      
//      log.printf("----------------------------------------------------\n");
//      
//      tc2 += sc2[2]; tc3 += sc3[2];
//      cst1 += sc2[3]; cst2 += sc3[3];
//    }
//    
//    //calculating the averages of total time
//    double avg_tc2 = tc2/numExecutions;
//    double avg_tc3 = tc3/numExecutions;
//    log.printf("AVG_T1 AVG_T2\n");
//    log.printf(avg_tc2 + " " + avg_tc3 + "\n");
//    
//    //calculating speedups
//    double sp2 = (avg_tc2 - avg_tc3) / avg_tc2;
//    
//    log.printf("speedup\n");
//    log.printf(sp2*100 + "\n");
//    
//  //calculating the averages of cstime
//    double avg_cst1 = cst1/numExecutions;
//    double avg_cst2 = cst2/numExecutions;
//    log.printf("AVG_CST1 AVG_CST2\n");
//    log.printf(avg_cst1 + " " + avg_cst2 + "\n");
//    
//    
//    log.close();
    
//    Set<String> allDistinctMethods = Methods.getAllDistinctMethods(path);
//    int totalMethods = allDistinctMethods.size();
//    System.out.println("#Methods = " + totalMethods);
//
//    // run SPLat/EvoSPLat
//    EvoSPLat evosplat = new EvoSPLat(ElevatorVariables.getSINGLETON(), allDistinctMethods);
//    evosplat.run(args, bound);

  }

  // public static void main(String[] args) throws Exception {
  // SPLat splat = new SPLat(ElevatorVariables.getSINGLETON());
  // splat.run(args);
  // }

}
