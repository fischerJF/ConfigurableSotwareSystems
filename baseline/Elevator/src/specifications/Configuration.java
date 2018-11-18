package specifications;


public class Configuration {

	public static boolean base = true;
	public static boolean weight = false;
	public static boolean empty = false;
	public static boolean twothirdsfull = false;
	public static boolean executivefloor = false;
	public static boolean overloaded = false;

	public static boolean validProduct() {
	
		return (!overloaded || weight) && (!twothirdsfull || weight) && base;
		            
	}

	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		weight = Boolean.valueOf(args[index++]);
		empty = Boolean.valueOf(args[index++]);
		twothirdsfull = Boolean.valueOf(args[index++]);
		executivefloor = Boolean.valueOf(args[index++]);
		overloaded = Boolean.valueOf(args[index++]);
		
	}

}