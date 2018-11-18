package experimento;

import guidsl.SATtest;
import guidsl.Tool;

public class MainTool {

	   static Tool tool = null;
	   static boolean makeCnfFile = true;
	   static boolean compatSelections = true;

	   public static void main( String args[] ) {
		  String modelFilePath="modified-model.m";
	      tool = new Tool( modelFilePath );

	      // verifies that IPOW and BIGI are compatible
//	      SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
//	      t.add("-BASE___");
//	      runTest( t, makeCnfFile );
	      

	     
	   }

//	   static void runTest( SATtest t, boolean compat ) {
//	      if (tool.modelDebug(t, makeCnfFile ))
//	         System.out.println(t.getName() + " succeeded");
//	      else
//	         System.out.println(t.getName() + " failed");
//	   }

	   public static boolean runTest( SATtest t, boolean compat ) {
		      if (tool.modelDebug(t, makeCnfFile ))
		        return true;
		      
		      
		      return false;
		 }

}
