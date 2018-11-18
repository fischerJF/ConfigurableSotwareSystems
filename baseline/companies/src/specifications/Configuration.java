package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

  public static boolean TREE_STRUCTURE = true;
  public static boolean LOGGING =false;
  public static boolean CUT_WHATEVER=false;
  public static boolean CUT_NO_DEPARTMENT =false;
  public static boolean CUT_NO_MANAGER =false;
  public static boolean GUI=false;
  public static boolean PRECEDENCE=false;
  public static boolean TOTAL_WALKER =false;
  public static boolean TOTAL_REDUCER =false;
  public static boolean ACCESS_CONTROL=false;
  
  
  public static Tool tool = new Tool( "modified-model.m" );
  public static boolean makeCnfFile = true;
  public static boolean compatSelections = true;
        

  
  public static boolean validProduct() {
    
    SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
    t.add(setTREE_STRUCTURE());
    t.add(setLOGGING());
    t.add(setCUT_WHATEVER());
    t.add(setCUT_NO_DEPARTMENT());
    t.add(setCUT_NO_MANAGER());
    t.add(setGUI());
    t.add(setPRECEDENCE());
    t.add(setTOTAL_WALKER());
    t.add(setTOTAL_REDUCER());
    t.add(setACCESS_CONTROL());
   
        
       return runTest( t, makeCnfFile ); 
  }
  
  public static boolean runTest( SATtest t, boolean compat ) {
    return (tool.modelDebug(t, makeCnfFile ))? true: false;
  }
  public static String setTREE_STRUCTURE() {
    return (TREE_STRUCTURE) ? "TREE_STRUCTURE___" : "-TREE_STRUCTURE___";
  }
  public static String setLOGGING() {
    return (LOGGING) ? "LOGGING___" : "-LOGGING___";
  }  
  public static String setCUT_WHATEVER() {
    return (CUT_WHATEVER) ? "CUT_WHATEVER___" : "-CUT_WHATEVER___";
  }  
  public static String setCUT_NO_DEPARTMENT() {
    return (CUT_NO_DEPARTMENT) ? "CUT_NO_DEPARTMENT___" : "-CUT_NO_DEPARTMENT___";
  }
  public static String setCUT_NO_MANAGER() {
    return (CUT_NO_MANAGER) ? "CUT_NO_MANAGER___" : "-CUT_NO_MANAGER___";
  }
  public static String setGUI() {
    return (GUI) ? "GUI___" : "-GUI___";
  }
  public static String setPRECEDENCE() {
    return (PRECEDENCE) ? "PRECEDENCE___" : "-PRECEDENCE___";
  }
  public static String setTOTAL_WALKER() {
    return (TOTAL_WALKER) ? "TOTAL_WALKER___" : "-TOTAL_WALKER___";
  }
  public static String setTOTAL_REDUCER() {
    return (TOTAL_REDUCER) ? "TOTAL_REDUCER___" : "-TOTAL_REDUCER___";
  }
  public static String setACCESS_CONTROL() {
    return (ACCESS_CONTROL) ? "ACCESS_CONTROL___" : "-ACCESS_CONTROL___";
  }
  
    
  
  public static void productPrint() {
    System.out.println("\t TREE_STRUCTURE:" + Configuration.TREE_STRUCTURE+ 
               "\t LOGGING:  " + Configuration.LOGGING + 
               "\t CUT_WHATEVER: "+Configuration.CUT_WHATEVER+ 
               "\t CUT_NO_DEPARTMENT:  "+ Configuration.CUT_NO_DEPARTMENT+
               "\t CUT_NO_MANAGER: "+Configuration.CUT_NO_MANAGER +
               "\t GUI: "+Configuration.GUI+
               "\t PRECEDENCE: "+Configuration.PRECEDENCE+
               "\t TOTAL_WALKER: "+Configuration.TOTAL_WALKER+
                "\t TOTAL_REDUCER: "+Configuration.TOTAL_REDUCER+
               "\t ACCESS_CONTROL: "+Configuration.ACCESS_CONTROL);
        System.out.println(); 
  }

  
  public static void init(String... args) {
    int index = 0;
    TREE_STRUCTURE = Boolean.valueOf(args[index++]);    
    LOGGING = Boolean.valueOf(args[index++]);
    CUT_WHATEVER = Boolean.valueOf(args[index++]);
    CUT_NO_DEPARTMENT = Boolean.valueOf(args[index++]);
    CUT_NO_MANAGER = Boolean.valueOf(args[index++]);
    GUI = Boolean.valueOf(args[index++]);
    PRECEDENCE = Boolean.valueOf(args[index++]);
    TOTAL_WALKER = Boolean.valueOf(args[index++]);
    TOTAL_REDUCER = Boolean.valueOf(args[index++]);
    ACCESS_CONTROL = Boolean.valueOf(args[index++]);
    
  }
  
  
  
}