package testset;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ElevatorTest.class, 
	EnvironmentTest.class, 
	ActionsTest.class,
	FloorTest.class, 
	PersonTest.class, 
	MainTest.class
})

public class TestAll { }