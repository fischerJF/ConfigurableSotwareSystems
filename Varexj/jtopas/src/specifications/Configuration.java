package specifications;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

  
  
  
  @Conditional
  public static boolean BASE = true;
  @Conditional  
  public static boolean TOKENPOSONLY = false;
  @Conditional  
  public static boolean COUNTLINES = false;
  @Conditional  
  public static boolean IMAGEPARTS = false;
  @Conditional  
  public static boolean BLOCKCOMMENTS = false;
  @Conditional  
  public static boolean LINECOMMENTS = false;

	public static boolean validProduct() {
	
		return true;
		            
	}

	public static void init(String... args) {
		int index = 0;
		BASE = Boolean.valueOf(args[index++]);		
		TOKENPOSONLY = Boolean.valueOf(args[index++]);
		IMAGEPARTS = Boolean.valueOf(args[index++]);
		COUNTLINES = Boolean.valueOf(args[index++]);
		BLOCKCOMMENTS = Boolean.valueOf(args[index++]);
		LINECOMMENTS = Boolean.valueOf(args[index++]);
		
	}

	public static int SMALL_LOOPS = 40;
	public static String INPUT_PIECE;
}