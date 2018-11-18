package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import splat.ElevatorVariables;


public abstract class ElevatorTest {
  
  @Rule 
  public TestName testName = new TestName();
  
  @Rule
  public Timeout globalTimeout = new Timeout(30000);

  @Before
  public void setup() {
        configure();
  }
  
  protected void configure() {
    ElevatorVariables.getSINGLETON().setBASE___(true);
  }
  
  @After
  public void teardown() {
//    ElevatorVariables.getSINGLETON().reset();
  }
  
}