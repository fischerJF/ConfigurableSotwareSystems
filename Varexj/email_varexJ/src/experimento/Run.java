package experimento;
import java.io.File;

import gov.nasa.jpf.JPF;

public class Run {

	public static void main(String[] _) {
		final String path = new File("").getAbsolutePath();
		final String[] args = {
				"+classpath=" + path + "/bin",
				"+search.class=.search.RandomSearch",
				"main." + "Main2"
		};

		JPF.main(args);
	}
}
