package splat;

import java.io.File;

public class PrintCLASSPATH {
	public static void main(String args[])
	{
		JavaUtility.INSTANCE.writeToFile(System.getProperty("user.dir") + File.separator + "classpath.txt", System.getProperty("java.class.path"));
	}
}
