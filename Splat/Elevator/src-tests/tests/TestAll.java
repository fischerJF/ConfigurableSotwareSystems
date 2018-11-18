package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  ActionsTestSplat.class,
  ElevatorTestSplat.class,
  EnvironmentTestSplat.class,
  FloorTest.class,
  PersonTestSplat.class
   })
public class TestAll extends ElevadorTest {
}
