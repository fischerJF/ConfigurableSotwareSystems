package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import specifications.Configuration;


public abstract class EmailTest {

	@Rule
	public TestName testName = new TestName();
	
//	@Rule
//  public Timeout globalTimeout = new Timeout(30000);

	@Before
	public void setup() {
		configure();
	}

	protected void configure() {
		//EmailVariables.getSINGLETON().setBASE___(true);
		Configuration.base=true;
	}

	@After
	public void teardown() {
//		EmailVariables.getSINGLETON().reset();
	}

}