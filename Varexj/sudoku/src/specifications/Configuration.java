package specifications;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

  
  
  
	//@Conditional
	public static boolean BASE = true;
	@Conditional
	public static boolean STATES = true;
	@Conditional
	public static boolean UNDO = false;
	@Conditional
	public static boolean COLOR = false;
	@Conditional
	public static boolean SOLVER = false;
	@Conditional
	public static boolean GENERATOR = false;
	@Conditional
	public static boolean EXTENDEDSUDOKU = false;

	public static boolean validProduct() {
	
		return true;
		            
	}

	public static void init(String... args) {
		int index = 0;
		BASE = Boolean.valueOf(args[index++]);		
		STATES = Boolean.valueOf(args[index++]);
		UNDO = Boolean.valueOf(args[index++]);
		COLOR = Boolean.valueOf(args[index++]);
		SOLVER = Boolean.valueOf(args[index++]);
		GENERATOR = Boolean.valueOf(args[index++]);
		EXTENDEDSUDOKU = Boolean.valueOf(args[index++]);
		
	}

}