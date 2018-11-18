package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
EmailTest.class,
TestMAB.class,
TestMain.class
})

public class TestAll extends EmailTest{ }