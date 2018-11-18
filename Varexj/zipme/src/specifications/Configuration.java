package specifications;

import gov.nasa.jpf.annotation.Conditional;

public class Configuration {

  
  //@Conditional 
  public static boolean  BASE= true;   
  //@Conditional 
  public static boolean  COMPRESS= false;   
  @Conditional  
  public static boolean  GZIP= false;   
  @ Conditional   
  public static boolean  EXTRACT= false;   
  @ Conditional   
  public static boolean ARCHIVECHECK= false;   
  @ Conditional   
  public static boolean  CRC= false;   
  @ Conditional   
  public static boolean  ADLER32CHECKSUM= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_COMPRESS_ADLER32CHECKSUM= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_COMPRESS_CRC= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_COMPRESS_GZIP= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_COMPRESS_GZIPCRC= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_EXTRACT_CRC= false;   
  @ Conditional   
  public static boolean  DERIVATIVE_GZIPCRC= false;
  
	public static boolean validProduct() {
	
		return true;
		            
	}

	public static void init(String... args) {
		int index = 0;
		BASE = Boolean.valueOf(args[index++]);		
		COMPRESS = Boolean.valueOf(args[index++]);
		GZIP = Boolean.valueOf(args[index++]);
		EXTRACT = Boolean.valueOf(args[index++]);
		ARCHIVECHECK = Boolean.valueOf(args[index++]);
		CRC = Boolean.valueOf(args[index++]);
		ADLER32CHECKSUM = Boolean.valueOf(args[index++]);
		DERIVATIVE_COMPRESS_ADLER32CHECKSUM = Boolean.valueOf(args[index++]);
		DERIVATIVE_COMPRESS_CRC = Boolean.valueOf(args[index++]);
		DERIVATIVE_COMPRESS_GZIP = Boolean.valueOf(args[index++]);
		DERIVATIVE_COMPRESS_GZIPCRC = Boolean.valueOf(args[index++]);
		DERIVATIVE_EXTRACT_CRC = Boolean.valueOf(args[index++]);
		DERIVATIVE_GZIPCRC = Boolean.valueOf(args[index++]);
		
	}

}