package smashed_varexj;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

	@Conditional
	public static boolean base = true;
	@Conditional
	public static boolean DIRECTED = true;
	@Conditional
	public static boolean UNDIRECTED = false;
	@Conditional
	public static boolean WEIGHTED = false;
	@Conditional
	public static boolean SEARCH = false;
	@Conditional
	public static boolean BFS = false;
	@Conditional
	public static boolean NUMBER = false;
	@Conditional
	public static boolean CONNECTED = false;
	@Conditional
	public static boolean STRONGLYCONNECTED = false;
	@Conditional
	public static boolean CYCLE = false;
	@Conditional
	public static boolean MSTPRIM = false;
	@Conditional
	public static boolean MSTKRUSKAL = false;
	@Conditional
	public static boolean SHORTEST = false;

	

	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		DIRECTED = Boolean.valueOf(args[index++]);
		UNDIRECTED = Boolean.valueOf(args[index++]);
		WEIGHTED  = Boolean.valueOf(args[index++]);
		SEARCH = Boolean.valueOf(args[index++]);
		BFS= Boolean.valueOf(args[index++]);
		NUMBER= Boolean.valueOf(args[index++]);
		CONNECTED= Boolean.valueOf(args[index++]);
		STRONGLYCONNECTED= Boolean.valueOf(args[index++]);
		CYCLE= Boolean.valueOf(args[index++]);
		MSTPRIM= Boolean.valueOf(args[index++]);
		MSTKRUSKAL= Boolean.valueOf(args[index++]);
		SHORTEST= Boolean.valueOf(args[index++]);
		
		
		
	}

}