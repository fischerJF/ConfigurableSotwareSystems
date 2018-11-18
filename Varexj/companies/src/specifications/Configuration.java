package specifications;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

	@Conditional
	public static boolean TREE_STRUCTURE = true;
	@Conditional
  public static boolean LOGGING =false;
  @Conditional
  public static boolean CUT_WHATEVER=false;
  @Conditional
  public static boolean CUT_NO_DEPARTMENT =false;
  @Conditional
  public static boolean CUT_NO_MANAGER =false;
  @Conditional
  public static boolean GUI=false;
  @Conditional
  public static boolean PRECEDENCE=false;
  @Conditional
  public static boolean TOTAL_WALKER =false;
  @Conditional
  public static boolean TOTAL_REDUCER =false;
  @Conditional
  public static boolean ACCESS_CONTROL=false;
	
  
  public static boolean validProduct() {
	
		return true;
		            
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