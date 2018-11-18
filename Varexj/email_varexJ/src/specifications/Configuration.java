package specifications;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

	@Conditional
	public static boolean base = true;
	@Conditional
	public static boolean KEYS = true;
	@Conditional
	public static boolean ENCRYPT = false;
	@Conditional
	public static boolean AUTORESPONDER = false;
	@Conditional
	public static boolean ADDRESSBOOK = false;
	@Conditional
	public static boolean SIGN = false;
	@Conditional
	public static boolean FORWARD = false;
	@Conditional
	public static boolean VERIFY = false;
	@Conditional
	public static boolean DECRYPT = false;

	public static boolean validProduct() {
	
		return true;
		            
	}

	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		KEYS  = Boolean.valueOf(args[index++]);
		ENCRYPT = Boolean.valueOf(args[index++]);
		AUTORESPONDER = Boolean.valueOf(args[index++]);
		ADDRESSBOOK = Boolean.valueOf(args[index++]);
		SIGN = Boolean.valueOf(args[index++]);
		FORWARD = Boolean.valueOf(args[index++]);
		VERIFY  = Boolean.valueOf(args[index++]);
		DECRYPT  = Boolean.valueOf(args[index++]);
		
	}

}