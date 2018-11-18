package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration  {

	public static boolean base = true;
	public static boolean KEYS = true;
	public static boolean ENCRYPT = false;
	public static boolean AUTORESPONDER = false;
	public static boolean ADDRESSBOOK = false;
	public static boolean SIGN = false;
	public static boolean FORWARD = false;
	public static boolean VERIFY = false;
	public static boolean DECRYPT = false;

	public boolean validate;
	public static Tool tool = new Tool( "modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    
	public static boolean validProduct() {
		productPrint();
		SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
		t.add(setBase());
		t.add(setKEYS());
		t.add(setENCRYPT());
		t.add(setAUTORESPONDER());
		t.add(setADDRESSBOOK());
		t.add(setSIGN());
		t.add(setFORWARD());
		t.add(setVERIFY() );
	    t.add(setDECRYPT());
	      
	     return runTest( t, makeCnfFile ); 
	}	
	public static boolean runTest( SATtest t, boolean compat ) {
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}
	public static String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public static String setKEYS() {
		return (KEYS) ? "KEYS___" : "-KEYS___";
	}	
	public static String setENCRYPT() {
		return (ENCRYPT) ? "ENCRYPT___" : "-ENCRYPT___";
	}	
	public static String setAUTORESPONDER() {
		return (AUTORESPONDER) ? "AUTORESPONDER___" : "-AUTORESPONDER___";
	}
	public static String setADDRESSBOOK() {
		return (ADDRESSBOOK) ? "ADDRESSBOOK___" : "-ADDRESSBOOK___";
	}
	public static String setSIGN() {
		return (SIGN) ? "SIGN___" : "-SIGN___";
	}
	public static String setFORWARD() {
		return (FORWARD) ? "FORWARD___" : "-FORWARD___";
	}
	public static String setVERIFY() {
		return (VERIFY) ? "VERIFY___" : "-VERIFY___";
	}
	public static String setDECRYPT() {
		return (DECRYPT) ? "DECRYPT___" : "-DECRYPT___";
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
	
	public static void productPrint() {
		System.out.println("\t KEYS:" + Configuration.KEYS+ 
		           "\t ENCRYPT:  " + Configuration.ENCRYPT + 
		           "\t AUTORESPONDER: "+Configuration.AUTORESPONDER+ 
		           "\t ADDRESSBOOK:  "+ Configuration.ADDRESSBOOK+
		           "\t SIGN: "+Configuration.SIGN +
		           "\t FORWARD: "+Configuration.FORWARD+
		           "\t VERIFY: "+Configuration.VERIFY+
		           "\t DECRYPT: "+Configuration.DECRYPT);
        System.out.println();
	}

}